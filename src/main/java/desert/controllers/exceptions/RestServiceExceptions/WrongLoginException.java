package desert.controllers.exceptions.RestServiceExceptions;

import org.springframework.http.HttpStatus;

/**
 * Created by Dim Mesh on 25.10.2016.  18:32
 */
public class WrongLoginException extends RuntimeException implements RestException {

    public WrongLoginException() {
        super("Wrong login or password");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
