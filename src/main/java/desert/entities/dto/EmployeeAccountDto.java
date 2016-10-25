package desert.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import desert.entities.EmployeeAccount;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Dim Mesh on 12.10.2016.  21:43
 */


@JsonInclude(JsonInclude.Include.NON_NULL)

public class EmployeeAccountDto extends AccountDto implements Serializable {

    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;

    public EmployeeAccountDto(){
        setType(TypesOfAccounts.EMPLOYEE);
    }

    public EmployeeAccountDto(EmployeeAccount employeeAccount){
        setType(TypesOfAccounts.EMPLOYEE);
        this.id = employeeAccount.getId();
        this.firstName = employeeAccount.getFirstName();
        this.lastName = employeeAccount.getLastName();
    }

}
