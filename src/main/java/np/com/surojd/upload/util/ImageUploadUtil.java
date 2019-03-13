package np.com.surojd.upload.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUploadUtil {

    @Value("${app.images}")
    public String imageLocation;

    @PostConstruct
    public void post() {
        File file = new File(imageLocation);
        file.mkdir();
    }

    public String imageUpload(MultipartFile image, String optionl) {
        if (image != null && image.getContentType() != null && image.getContentType().startsWith("image")) {
            try {
                String imageName = optionl + "_" + new Date().getTime() + ".jpg";
                File f = new File(imageLocation + imageName);
                f.createNewFile();
                byte[] bytes = image.getBytes();
                try (FileOutputStream fos = new FileOutputStream(f)) {
                    fos.write(bytes);
                    fos.flush();
                }
                return imageName;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

}
