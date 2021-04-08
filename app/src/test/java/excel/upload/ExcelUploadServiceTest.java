package excel.upload;

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

}
