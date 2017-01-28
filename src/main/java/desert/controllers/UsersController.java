package desert.controllers;

/**
 * Created by Dim Mesh on 02.10.2016.  11:29
 */
import desert.entities.User;
import desert.entities.dto.UserDto;
import desert.entities.enums.Result;
import desert.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/users")

public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public Result<UserDto> getUsers() {
        ArrayList<UserDto> result = new ArrayList<>();
        usersService.findAll().forEach(user -> {
            result.add(new UserDto(user));
        });
        return new Result<UserDto>(result);
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDto> update(@RequestBody UserDto user) {
        //no empty fields allowed

        if(user != null){
            if(user.getAccount() != null){
                usersService.addGuest(user);
            } else {
                usersService.addEmptyGuest(user);
            }
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    Result getUserById(@PathVariable long userId) {

        User user = usersService.getUserById(userId);

        return  new Result<UserDto>(new UserDto(user));
    }
    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    ResponseEntity deleteUserById(@PathVariable long userId) {
        usersService.deleteUserById(userId);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
}
