package desert.controllers.exceptions;

import desert.controllers.exceptions.RestServiceExceptions.RestException;
import desert.controllers.exceptions.RestServiceExceptions.UserNotFoundException;
import desert.entities.dto.ErrorDto;
import desert.entities.enums.Result;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dim Mesh on 21.10.2016.  0:19
 */
/*
    Controller for handle some types of http errors.
*/
@RestController
@ControllerAdvice
@Order(ExceptionHandlerExceptionResolver.HIGHEST_PRECEDENCE)
public class RestErrorController {

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Result userNotFoundExceptionHandler(HttpServletRequest request, UserNotFoundException ex) {
        return new Result( new ErrorDto(ex,request) );
    }


}



