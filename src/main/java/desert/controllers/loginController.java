package desert.controllers;

import desert.controllers.exceptions.RestServiceExceptions.RestException;
import desert.controllers.exceptions.RestServiceExceptions.WrongLoginException;
import desert.entities.User;
import desert.entities.dto.ErrorDto;
import desert.entities.dto.UserDto;
import desert.entities.enums.Result;
import desert.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    Result failure(HttpServletRequest request) {
        RestException ex = new WrongLoginException();
        return  new Result(new ErrorDto(ex, request));
    }
}
