package excel.upload.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequisiteException extends RuntimeException {
    public RequisiteException(String error) {
        super(error);
    }
}
