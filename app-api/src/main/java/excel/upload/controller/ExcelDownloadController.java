package excel.upload.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
public class ExcelDownloadController {

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> download() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Price&Inventory");
        Row headerRow = sheet.createRow(0);
        Cell cell = headerRow.createCell(0);
        cell.setCellValue("TEST");
        workbook.write(out);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(out.toByteArray());


        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=test.xlsx");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(inputStream));
    }


}
