package desert.entities.enums;

import desert.entities.dto.ErrorDto;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;

/**
 * Created by Dim Mesh on 21.10.2016.  0:25
 */
public class Result<T> {
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

    public ArrayList<T> getData() {
        if(data != null ){
            return data;
        }
        return null;
    }

    public void setData(ArrayList<T> data) {
        this.data = data;
    }

    public ErrorDto getError() {
        return error;
    }

    public void setError(ErrorDto error) {
        this.error = error;
    }

    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean status) {
        this.success = status;
    }

    public int getCount() {
        if(data != null) {
            this.count = data.size();
        }
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
