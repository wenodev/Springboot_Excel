package excel.upload.service;

import excel.upload.entity.Product;
import excel.upload.entity.ProductRepository;
import excel.upload.exception.ExcelExtensionNotFoundException;
import excel.upload.exception.RequisiteException;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        int name = 0; // 필수값
        int price = 1; // 필수값
        int weight = 2; // 선택값
        int description = 3; // 필수값
        int imgUrl = 4; // 필수값
        List<Product> products = new ArrayList<>();

        for (Row row : sheet){

            //1번째 row 건너뛰기
            if (row.getRowNum() == 0){
                continue;
            }
            // 필수값체크
            if (row.getCell(name) == null || row.getCell(price) == null || row.getCell(description) == null || row.getCell(imgUrl) == null){
                throw new RequisiteException(row.getRowNum() + "번째 Row에 필수값을 확인하세요.");
            }

            products.add(Product.builder()
                    .name(row.getCell(name).getStringCellValue())
                    .price((int) row.getCell(price).getNumericCellValue())
                    .weight((row.getCell(weight) == null) ? null : row.getCell(weight).getNumericCellValue())
                    .description(row.getCell(description).getStringCellValue())
                    .imgUrl(row.getCell(imgUrl).getStringCellValue())
                    .build());
        }
        productRepository.saveAll(products);
        
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
