package excel.upload.service;

import excel.upload.entity.ProductRepository;
import excel.upload.exception.ExcelExtensionNotFoundException;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Transactional
@Service
public class ExcelUploadService {

    private final ProductRepository productRepository;

    public ExcelUploadService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void uploadProduct(MultipartFile file) throws IOException {
        Workbook workbook = MakeWorkBooK(file);
        Sheet sheet = workbook.getSheetAt(0);
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
