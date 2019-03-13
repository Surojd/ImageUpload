package np.com.surojd.upload;

import java.util.Date;
import lombok.Data;

@Data
public class ResponseDto {

    String message;
    Date date = new Date();
    boolean status = true;
}
