package desert.services.impl;

/**
 * Created by Dim Mesh on 29.09.2016.  21:57
 */
    import desert.entities.User;
    import desert.entities.repositories.UsersRepository;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.security.authentication.InternalAuthenticationServiceException;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.stereotype.Service;

@Service
public class MySQLUserDetailsService implements UserDetailsService {
    @Autowired
    UsersRepository users;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails loadedUser;

        try {
            User client = users.findByUsername(username);
            if (client == null) {
                throw new UsernameNotFoundException("Username " + username + " not found");
            }
            loadedUser = new org.springframework.security.core.userdetails.User(
                    client.getUsername(),
                    client.getPassword(),
                    client.getRoles()
            );
        } catch (Exception repositoryProblem) {
            throw new InternalAuthenticationServiceException(repositoryProblem.getMessage(), repositoryProblem);
        }
        return loadedUser;
    }
}