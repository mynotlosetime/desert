package desert.controllers.exceptions;

import desert.entities.dto.ErrorDto;
import desert.entities.enums.Result;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.boot.autoconfigure.web.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Dim Mesh on 26.10.2016.  16:00
 */

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class BasicErrorController extends AbstractErrorController {

    private static final String PATH = "/error";

    public BasicErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }
    // add details handle for other errors
    @RequestMapping
    @ResponseBody
    public Result exceptions(HttpServletRequest request, HttpServletResponse response, RuntimeException ex) {
        Map<String, Object> errorMap = getErrorAttributes(request,true);
        ErrorDto error = new ErrorDto(errorMap);
        return new Result(error);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}

