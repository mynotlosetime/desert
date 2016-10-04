package desert.controllers;

/**
 * Created by Dim Mesh on 02.10.2016.  11:29
 */
import desert.entities.User;
import desert.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")

public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers()
    {
        List<User> result = new ArrayList<>();
        usersService.findAll().forEach(result::add);
        return result;
    }
    @RequestMapping(method = RequestMethod.POST)
    public User addUser(String username,
                        String password,
                        String firstName,
                        String lastName,
                        String password_confirm)
    {
        //no empty fields allowed

        if (username.isEmpty() || password.isEmpty() || password_confirm.isEmpty())
            return null;
        //passwords should match
        if (!password.equals(password_confirm))
            return null;

        return usersService.addGuest(new User(username, password),firstName,lastName);
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public ModelAndView getUserForm()
    {
        return new ModelAndView("add");
    }
}
