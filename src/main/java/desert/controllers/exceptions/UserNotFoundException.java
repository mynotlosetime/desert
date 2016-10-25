package desert.controllers.exceptions;

/**
 * Created by Dim Mesh on 22.10.2016.  14:41
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long userId) {
        super("user with id " + userId + " not found");
    }
}