package excel.upload.controller;

import excel.upload.service.ExcelUploadService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("/upload/product")
@RestController
public class ExcelUploadController {

    private final ExcelUploadService excelUploadService;

    public ExcelUploadController(ExcelUploadService excelUploadService) {
        this.excelUploadService = excelUploadService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void uploadProduct(@RequestParam("file")MultipartFile file) throws IOException {
        excelUploadService.uploadProduct(file);
    }
}
