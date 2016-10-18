package desert.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import desert.entities.User;

import java.io.Serializable;

/**
 * Created by Dim Mesh on 12.10.2016.  20:40
 */

@JsonInclude(JsonInclude.Include.NON_NULL)

public class UserDto implements Serializable {
    private String name;
    private String password;
    private AccountDto account;

    public UserDto(){}

    public UserDto(User user){
        this.name = user.getUsername();
        this.password = user.getPassword();
        if(user.getEmployeeAccount() != null){
            this.account = new EmployeeAccountDto(user.getEmployeeAccount());
        } else if(user.getCompanyAccount() != null){
            this.account = new CompanyAccountDto(user.getCompanyAccount());
        }
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public AccountDto getAccount() {
        return account;
    }

    public void setAccount(AccountDto account) {
        this.account = account;
    }
}
