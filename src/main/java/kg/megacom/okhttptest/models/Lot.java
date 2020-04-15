package kg.megacom.okhttptest.models;

import lombok.Data;
import java.util.Date;

@Data
public class Lot {
    private Integer id;
    private String LotName;
    private double minPrice;
    private double lotPrice;
    private double step;
    private Date startDate;
    private Date endDate;
    private StatusDto statusDto;

}
