package desert.entities.dto;

import desert.controllers.exceptions.RestServiceExceptions.RestException;
import lombok.Data;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dim Mesh on 24.10.2016.  22:08
 */
public @Data class ErrorDto {

    private int status;
    private String name, exception, message, path, timestamp;


    public ErrorDto(Map<String,Object> basicError){
        name = (String) basicError.get("error");
        path = (String) basicError.get("path");
        status = (int) basicError.get("status");
        timestamp = new Date().toString();
        exception = (String) basicError.get("exception");
        message = (String) basicError.get("message");
    }
    public ErrorDto(RestException ex, HttpServletRequest request){
        name = ex.getStatus().getReasonPhrase();
        path =  request.getRequestURI();
        status =  ex.getStatus().value();
        timestamp = new Date().toString();
        exception = ex.getClass().getName();
        message = ex.getMessage();
    }
}
