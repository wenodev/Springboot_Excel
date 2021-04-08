package excel.upload;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExcelUploadController.class)
class ExcelUploadControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private static final String BASE_URL = "/upload/product";

    @BeforeEach
    void setUp() {
    }

    @Test
    void uploadProduct() throws Exception {
        mockMvc.perform(post(BASE_URL))
                .andExpect(status().isCreated());
    }

}
