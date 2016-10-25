package desert.controllers.exceptions;

/**
 * Created by Dim Mesh on 25.10.2016.  18:32
 */
public class WrongLoginException extends RuntimeException {

    public WrongLoginException() {
        super("Wrong login or password");
    }
}
