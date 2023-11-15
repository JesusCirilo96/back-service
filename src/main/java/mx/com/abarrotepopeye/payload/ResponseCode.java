package mx.com.abarrotepopeye.payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class ResponseCode implements Serializable {

    String error;
    String codeError;
    String description;



}
