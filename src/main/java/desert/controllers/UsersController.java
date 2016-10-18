package desert.controllers;

/**
 * Created by Dim Mesh on 02.10.2016.  11:29
 */
import desert.entities.dto.UserDto;
import desert.entities.enums.RoleEnum;
import desert.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
@PreAuthorize("hasRole('ROLE_ADMIN')")

public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getUsers() {

        List<UserDto> result = new ArrayList<>();
        usersService.findAll().forEach(user -> {
            result.add(new UserDto(user));
        });
        return result;
    }
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<UserDto> update(@RequestBody UserDto user) {
        //no empty fields allowed
        if(user != null){
            usersService.addGuest(user);
        }
        return new ResponseEntity<UserDto>(user, HttpStatus.OK);
    }
}
