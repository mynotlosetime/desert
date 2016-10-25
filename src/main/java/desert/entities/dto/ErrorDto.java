package desert.entities.dto;

/**
 * Created by Dim Mesh on 24.10.2016.  22:08
 */
public class ErrorDto {
    private String message;
    private String name;

    public ErrorDto(RuntimeException exception){
        this.message = exception.getMessage();
        this.name = exception.getClass().getName();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
