package desert.services.impl;

import desert.entities.AccountEmployee;
import desert.entities.User;
import desert.entities.repositories.AccountsRepository;
import desert.entities.repositories.UsersRepository;
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
    UsersRepository users;

    @Autowired
    AccountsRepository accounts;

    @Transactional
    public User addGuest(User user,String firstName, String lastName){

        AccountEmployee accountEmployee = new AccountEmployee(firstName,lastName);
        accountEmployee.setUser(user);
        accounts.save(accountEmployee);

        user.setAccountEmployee(accountEmployee);
        users.save(user);

        return user;
    }

    public Iterable<User> findAll(){
        return users.findAll();
    }
}
