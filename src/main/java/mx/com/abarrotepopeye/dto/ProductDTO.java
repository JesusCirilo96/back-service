package mx.com.abarrotepopeye.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@ToString
@Builder
public class ProductDTO implements Serializable {

    private UUID productId;
    private String name;
    private BigDecimal price;
    private String barCode;
    private String status;
    private String category;
    private String createDate;
    private String updateDate;

}
