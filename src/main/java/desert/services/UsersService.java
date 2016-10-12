package desert.services;

import desert.entities.User;

/**
 * Created by Dim Mesh on 07.10.2016.  22:37
 */
public interface UsersService {

    User addGuest(User user, String firstName, String lastName);

    public Iterable<User> findAll();
}
