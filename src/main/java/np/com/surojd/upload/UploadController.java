package np.com.surojd.upload;

import java.util.List;
import javax.validation.Valid;
import np.com.surojd.upload.dao.DBFileDao;
import np.com.surojd.upload.database.DBFile;
import np.com.surojd.upload.util.ImageUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping
public class UploadController {

    @Autowired
    ImageUploadUtil uploadUtil;

    @Autowired
    DBFileDao fileDao;

    @PostMapping("upload")
    public String upload(@ModelAttribute @Valid ImageDto dto, BindingResult result, RedirectAttributes model) {
        if (result.hasErrors()) {
            model.addFlashAttribute("error", "Select Image");
        } else {
            String imageName = uploadUtil.imageUpload(dto.getImage(), "name");
            DBFile dbf = new DBFile();
            dbf.setFileName(imageName);
            fileDao.save(dbf);
        }
        return "redirect:/";
    }

    @GetMapping
    public String index(Model model) {
        List<DBFile> images = fileDao.findAll();
        model.addAttribute("images", images);
        return "index";
    }

    @GetMapping("error")
    public String error(RedirectAttributes model) {
        return "redirect:/";
    }

}
