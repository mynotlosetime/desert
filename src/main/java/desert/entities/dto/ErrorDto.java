package desert.entities.dto;

import lombok.Data;

/**
 * Created by Dim Mesh on 24.10.2016.  22:08
 */
public @Data class ErrorDto {
    private String message;
    private String name;

    public ErrorDto(RuntimeException exception){
        this.message = exception.getMessage();
        this.name = exception.getClass().getName();
    }
}
