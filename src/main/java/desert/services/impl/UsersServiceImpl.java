package desert.services.impl;

import desert.controllers.exceptions.UserNotFoundException;
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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Dim Mesh on 03.10.2016.  22:16
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    UsersRep usersRep;

    @Autowired
    AccountsService accountsService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User addGuest(UserDto userDto){
        User user = createUserFromDto(userDto);
        AccountDto accountDto = userDto.getAccount();
        if(accountDto != null) {
            if (accountDto.getClass() == CompanyAccountDto.class) {
                CompanyAccount account = accountsService.createCompanyAccount(user, (CompanyAccountDto) accountDto);
                user.setCompanyAccount(account);
                user.setRole(RoleEnum.ROLE_COMPANY);
            }
            else if (accountDto.getClass() == EmployeeAccountDto.class) {
                EmployeeAccount account = accountsService.createEmployeeAccount(user, (EmployeeAccountDto) accountDto);
                user.setEmployeeAccount(account);
                user.setRole(RoleEnum.ROLE_EMPLOYEE);
            }
        }
        usersRep.save(user);
        return user;
    }

    @Override
    public User addEmptyGuest(UserDto userDto){
        User user = createUserFromDto(userDto);
        user.setRole(RoleEnum.ROLE_ANONYMOUS);
        usersRep.save(user);
        return user;
    }

    @Override
    public User getUserById(long userId) {
        User user;
        if(usersRep.exists(userId)) {
            user = usersRep.getOne(userId);
        } else {
            throw new UserNotFoundException(userId);
        }
        return user; // .orElseThrow(() -> new UserNotFoundException(userId)
    }
    public User getUserByUsername(String username){
        User user = usersRep.findByUsername(username);
        if(user == null){
            throw new UserNotFoundException(username);
        }
        return user;
    }
    public void deleteUserById(long userId){
        try{
            usersRep.delete(userId);
        } catch( EmptyResultDataAccessException ex) {
            throw new UserNotFoundException(userId);
        }
    }

    private User createUserFromDto(UserDto userDto){
        return new User(userDto.getName(), passwordEncoder.encode(userDto.getPassword()));
    }
    public Iterable<User> findAll(){
        return usersRep.findAll();
    }
}
