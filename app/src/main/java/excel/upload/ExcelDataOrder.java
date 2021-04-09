package excel.upload;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum ExcelDataOrder {
    NAME(0, "필수", "STRING"),
    PRICE(1, "필수", "NUMERIC"),
    WEIGHT(2, "필수", "NUMERIC"),
    DESCRIPTION(3, "필수", "STRING"),
    IMG_URL(4, "필수", "STRING");

    private final Integer order;
    private final String option;
    private final String type;

    ExcelDataOrder(int order, String option, String type) {
        this.order = order;
        this.option = option;
        this.type = type;
    }

    public static ExcelDataOrder findByOrder(int order){
        return Arrays.stream(ExcelDataOrder.values())
                .filter(data -> data.order == order)
                .findFirst()
                .orElse(null);
    }

}
