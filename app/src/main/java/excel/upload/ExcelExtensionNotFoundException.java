package excel.upload;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExcelExtensionNotFoundException extends RuntimeException {
    public ExcelExtensionNotFoundException(String extension) {
        super(extension);
    }
}
