package np.com.surojd.upload;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImageDto {

    MultipartFile image;
}
