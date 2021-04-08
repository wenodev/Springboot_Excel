package excel.upload;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ExcelUploadService {
    public void uploadProduct(MultipartFile file) throws IOException {
        Workbook workbook = MakeWorkBooK(file);
    }

    private Workbook MakeWorkBooK(MultipartFile file) throws IOException {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if (extension.equals("xlsx")) {
            return new XSSFWorkbook(file.getInputStream());
        }
        if (extension.equals("xls")) {
            return new HSSFWorkbook(file.getInputStream());
        }
        throw new ExcelExtensionNotFoundException(extension);
    }
}
