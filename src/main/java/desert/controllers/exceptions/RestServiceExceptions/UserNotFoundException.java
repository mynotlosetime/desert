package desert.controllers.exceptions.RestServiceExceptions;

import org.springframework.http.HttpStatus;

/**
 * Created by Dim Mesh on 22.10.2016.  14:41
 */
public class UserNotFoundException extends RuntimeException implements RestException {


    public UserNotFoundException(Long userId) {
        super("User with id " + userId + " not found");
    }

    public UserNotFoundException(String username) {
        super("User with login" + username + " not found");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}