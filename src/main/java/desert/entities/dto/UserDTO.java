package desert.entities.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import desert.entities.User;
import desert.entities.enums.RoleEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Dim Mesh on 12.10.2016.  20:40
 */

@JsonInclude(JsonInclude.Include.NON_NULL)


public @Data class UserDto implements Serializable {
    private Long id;
    private String name;
    private String password;
    private String role;
    private AccountDto account;

    public UserDto(){}

    public UserDto(User user){
        this.id = user.getId();
        this.name = user.getUsername();
        RoleEnum role = user.getRole();
        this.role = role.name();
        if(!this.role.equals(RoleEnum.ROLE_ADMIN.name())) {
            if (user.getEmployeeAccount() != null) {
                this.account = new EmployeeAccountDto(user.getEmployeeAccount());
            } else if (user.getCompanyAccount() != null) {
                this.account = new CompanyAccountDto(user.getCompanyAccount());
            }
        }
    }
}
