package desert.services.impl;

/**
 * Created by Dim Mesh on 29.09.2016.  21:57
 */
    import desert.entities.User;
    import desert.entities.enums.RoleEnum;
    import desert.entities.repositories.UsersRep;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.authentication.InternalAuthenticationServiceException;
    import org.springframework.security.core.GrantedAuthority;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.stereotype.Service;

    import java.util.ArrayList;
    import java.util.Collection;

@Service
public class MySQLUserDetailsService implements UserDetailsService {
    @Autowired
    UsersRep users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails loadedUser;

        try {
            User client = users.findByUsername(username);
            if (client == null) {
                throw new UsernameNotFoundException("Username " + username + " not found");
            }
            ArrayList<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new Role(client.getRole()));

            loadedUser = new org.springframework.security.core.userdetails.User(
                    client.getUsername(),
                    client.getPassword(),
                    roles
            );
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        return loadedUser;
    }
}

class Role implements GrantedAuthority {

    private String role;

    protected Role(){}

    Role(RoleEnum name) {
        role = name.name();
    }

    /*========== Spring auth implementation ====*/

    @Override
    public String getAuthority() {
        return getRole();
    }

    /*=========== Self methods =================*/

    private String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}