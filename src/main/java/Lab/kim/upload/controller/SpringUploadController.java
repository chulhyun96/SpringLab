package Lab.kim.upload.controller;

import Lab.kim.upload.domain.UploadFile;
import Lab.kim.upload.file.FileStore;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Controller
@RequestMapping("/spring")
public class SpringUploadController {

    @Autowired
    private FileStore fileStore;


    @GetMapping("/upload")
    public String newFile() {
        return "upload-form";
    }

    @PostMapping("/upload")
    public String saveFile2(@RequestParam String itemName,
                           @RequestParam MultipartFile file,
                           HttpServletRequest request) throws IOException {

        UploadFile uploadFile = fileStore.storeFile(file);

        return "upload-form";
    }
}
