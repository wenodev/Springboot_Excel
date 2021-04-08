package excel.upload;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/upload/product")
@RestController
public class ExcelUploadController {

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void uploadProduct(){

    }
}
