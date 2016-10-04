package desert.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Dim Mesh on 02.10.2016.  11:14
 */
@Entity
@Table(name="roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String role;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    Set<User> users;

    protected Role(){}
    public Role(String name)
    {
        role = name;
    }

    /*========== Spring auth implementation ====*/

    @Override
    public String getAuthority() {
        return getRole();
    }


    /*========== For user wire ===============*/

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }


    /*=========== Self methods =================*/

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return "ROLE_" + role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

