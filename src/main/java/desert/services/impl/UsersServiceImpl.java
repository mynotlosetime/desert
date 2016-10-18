package desert.services.impl;

import desert.entities.*;
import desert.entities.dto.AccountDto;
import desert.entities.dto.CompanyAccountDto;
import desert.entities.dto.EmployeeAccountDto;
import desert.entities.dto.UserDto;
import desert.entities.enums.RoleEnum;
import desert.entities.repositories.UsersRep;
import desert.services.AccountsService;
import desert.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dim Mesh on 03.10.2016.  22:16
 */
@Component
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRep usersRep;

    @Autowired
    AccountsService accountsService;

    @Transactional
    public User addGuest(UserDto userDto){
        User user = new User(userDto.getName(), userDto.getPassword());
        AccountDto accountDto = userDto.getAccount();
        if(accountDto != null) {
            if (accountDto.getClass() == CompanyAccountDto.class) {
                CompanyAccount account = accountsService.createCompanyAccount(user, (CompanyAccountDto) accountDto);
                user.setCompanyAccount(account);
            }
            else if (accountDto.getClass() == EmployeeAccountDto.class) {
                EmployeeAccount account = accountsService.createEmployeeAccount(user, (EmployeeAccountDto) accountDto);
                user.setEmployeeAccount(account);
            }
        }

        /*Role role = rolesRep.findOne((long) RoleEnum.EMPLOYEE.ordinal());
        user.addRole(role);*/

        user.setRole(RoleEnum.ROLE_ADMIN);
        usersRep.save(user);

        return user;
    }

    public Iterable<User> findAll(){
        return usersRep.findAll();
    }
}
