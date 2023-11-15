package mx.com.abarrotepopeye.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class CategoryDTO implements Serializable {

    private Integer categoryId;
    private String name;
    private String status;
    private String createDate;
    private String updateDate;
}
