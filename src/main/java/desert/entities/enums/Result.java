package desert.entities.enums;

import desert.entities.dto.ErrorDto;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

/**
 * Created by Dim Mesh on 21.10.2016.  0:25
 */
public @Data class Result<T> {
    private ArrayList<T> data;
    private ErrorDto error;
    private boolean success;
    private int count;

    public Result(RuntimeException error){
        this.error = new ErrorDto(error);
        this.success = false;
    }
    public Result(T data){
        ArrayList<T> one = new ArrayList<>();
        one.add(data);
        this.data = one;
    }
    public Result( ArrayList<T> data){
        this.data = data;
        this.success = true;
    }
    public int getCount() {
        if(data != null) {
            this.count = data.size();
        }
        return count;
    }
}
