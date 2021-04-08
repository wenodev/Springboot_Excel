package excel.upload;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

class ExcelUploadServiceTest {

    private ClassPathResource file;

    @BeforeEach
    void setUp() throws IOException {
        file = new ClassPathResource("spring-excel-upload-product.xlsx");
    }

    @Test
    void testGetFile() throws IOException {
        assertThat(file.getFilename()).isEqualTo("spring-excel-upload-product.xlsx");
    }

    @Test
    void getWorkBookData() throws IOException {
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet workSheet = workbook.getSheetAt(0);
        Row firstRow = workSheet.getRow(0);
        assertThat(firstRow.getCell(0).getStringCellValue()).isEqualTo("상품명");
    }

}
