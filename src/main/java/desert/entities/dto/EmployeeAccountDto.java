package desert.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import desert.entities.EmployeeAccount;

import java.io.Serializable;

/**
 * Created by Dim Mesh on 12.10.2016.  21:43
 */


@JsonInclude(JsonInclude.Include.NON_NULL)

public class EmployeeAccountDto extends AccountDto implements Serializable {

    private String firstName;
    private String lastName;

    public EmployeeAccountDto(){
        setType(TypesOfAccounts.EMPLOYEE);
    }

    public EmployeeAccountDto(EmployeeAccount employeeAccount){
        setType(TypesOfAccounts.EMPLOYEE);
        this.id = employeeAccount.getId();
        this.firstName = employeeAccount.getFirstName();
        this.lastName = employeeAccount.getLastName();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
