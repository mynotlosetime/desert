package desert.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import desert.entities.dto.EmployeeAccountDto;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Dim Mesh on 04.10.2016.  21:00
 */
@Entity
@Table(name = "employee_accounts")
public @Data class EmployeeAccount implements Account{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne( mappedBy = "employeeAccount", fetch = FetchType.LAZY )
    private User user;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public EmployeeAccount(){}

    public EmployeeAccount(String firstName, String lastName) {
        this.lastName = lastName;
        this.firstName = firstName;
    }
    public EmployeeAccount(EmployeeAccountDto dto){
        this.lastName = dto.getLastName();
        this.firstName = dto.getFirstName();
    }
}
