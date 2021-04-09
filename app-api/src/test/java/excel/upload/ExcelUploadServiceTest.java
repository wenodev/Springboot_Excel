package excel.upload;

import excel.upload.entity.Product;
import excel.upload.exception.RequisiteException;
import org.apache.commons.io.FilenameUtils;
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
        Sheet sheet = workbook.getSheetAt(0);

        int name = 0; // 필수값
        int price = 1; // 필수값
        int weight = 2; // 선택값
        int description = 3; // 필수값
        int imgUrl = 4; // 필수값

        for (Row row : sheet){

            //1번째 row 건너뛰기
            if (row.getRowNum() == 0){
                continue;
            }

            // 필수값체크
            if (row.getCell(name) == null || row.getCell(price) == null || row.getCell(description) == null || row.getCell(imgUrl) == null){
                throw new RequisiteException(row.getRowNum() + "번째 Row에 필수값을 확인하세요.");
            }

            Product product = Product.builder()
                    .name(row.getCell(name).getStringCellValue())
                    .price((int) row.getCell(price).getNumericCellValue())
                    .weight((row.getCell(weight) == null) ? null : row.getCell(weight).getNumericCellValue())
                    .description(row.getCell(description).getStringCellValue())
                    .imgUrl(row.getCell(imgUrl).getStringCellValue())
                    .build();
        }
    }

    @Test
    void testExtension(){
        String extension = FilenameUtils.getExtension(file.getFilename());
        assertThat(extension).isEqualTo("xlsx");
    }
}
