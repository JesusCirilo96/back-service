package mx.com.abarrotepopeye.payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class MessageResponse implements Serializable {

    private String error;
    private String codeError;
    private String description;
    private String moreInfo;
    private Object response;
}
