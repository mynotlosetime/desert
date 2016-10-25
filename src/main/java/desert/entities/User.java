package desert.entities;

/**
 * Created by Dim Mesh on 29.09.2016.  22:03
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import desert.entities.enums.RoleEnum;
import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name="users")
public @Data class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "username")
    private String username;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "employee_account_id")
    private EmployeeAccount employeeAccount;

    @OneToOne
    @JoinColumn(name = "company_account_id")
    private CompanyAccount companyAccount;

    @Column(name = "role")
    @Enumerated(EnumType.ORDINAL)
    private RoleEnum role;

    protected User(){}
    public User(String name, String pass) {
        username = name;
        password = pass;
    }
}