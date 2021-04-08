package excel.upload;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExcelUploadController.class)
class ExcelUploadControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private MockMultipartFile file;

    private static final String BASE_URL = "/upload/product";


    @BeforeEach
    void setUp() {
        file = new MockMultipartFile(
                "file",
                "hello.xlsx",
                MediaType.TEXT_PLAIN_VALUE,
                "Hello ExcelWorld!".getBytes()
        );
    }

    @Test
    void uploadProduct() throws Exception {
        mockMvc.perform(multipart(BASE_URL).file(file))
                .andExpect(status().isCreated());
    }

}
