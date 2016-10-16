package desert.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import desert.entities.AccountEmployee;

import java.io.Serializable;

/**
 * Created by Dim Mesh on 12.10.2016.  21:43
 */

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AccountDto implements Serializable{
    private String firstName;
    private String lastName;

    public AccountDto(){}

    public AccountDto(AccountEmployee accountEmployee){
        this.firstName = accountEmployee.getFirstName();
        this.lastName = accountEmployee.getLastName();
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
