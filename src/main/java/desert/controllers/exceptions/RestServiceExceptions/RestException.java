package desert.controllers.exceptions.RestServiceExceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Created by Dim Mesh on 31.10.2016.  22:54
 */
public interface RestException {

    HttpStatus getStatus();

    String getMessage();
}
