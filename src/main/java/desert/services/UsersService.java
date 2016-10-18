package desert.services;

import desert.entities.User;
import desert.entities.dto.UserDto;

/**
 * Created by Dim Mesh on 07.10.2016.  22:37
 */
public interface UsersService {

    User addGuest(UserDto userDto);

    public Iterable<User> findAll();
}
