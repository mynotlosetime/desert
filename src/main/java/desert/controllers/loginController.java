package desert.controllers;

import desert.controllers.exceptions.WrongLoginException;
import desert.entities.User;
import desert.entities.dto.UserDto;
import desert.entities.enums.Result;
import desert.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dim Mesh on 25.10.2016.  18:29
 */
@RestController
@RequestMapping(value = "/login")
public class loginController {
    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/success/{username}", method = RequestMethod.GET)
    Result success(@PathVariable String username) {
        User user = usersService.getUserByUsername(username);

        return  new Result<UserDto>(new UserDto(user));
    }
    @RequestMapping(value = "/failure", method = RequestMethod.GET)
    Result failure() {
        return  new Result<>(new WrongLoginException());
    }
}
