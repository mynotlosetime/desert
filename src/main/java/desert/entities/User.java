package desert.entities;

/**
 * Created by Dim Mesh on 29.09.2016.  22:03
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import desert.entities.enums.RoleEnum;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
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


    /*========== For roles wire ===============*/


    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    /*=========== Self methods =================*/


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public EmployeeAccount getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(EmployeeAccount employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public CompanyAccount getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(CompanyAccount companyAccount) {
        this.companyAccount = companyAccount;
    }
}