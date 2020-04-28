package kg.megacom.okhttptest.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;

@Data
public class Lot {
    private Integer id;
    private String lotName;
    private double minPrice;
    private double lotPrice;
    private double step;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date startDate;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date endDate;
    private StatusDto statusDto;

}
