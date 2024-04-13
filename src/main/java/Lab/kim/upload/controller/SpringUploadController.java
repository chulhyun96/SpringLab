package Lab.kim.upload.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Controller
@RequestMapping("/spring")
public class SpringUploadController {
    @Value("${file.dir.image.main}")
    private String fileMainDir;

    @Value("${file.dir.image.sub}")
    private String fileSubDir;


    @GetMapping("/upload")
    public String newFile() {
        return "upload-form";
    }

    @PostMapping("/upload")
    public String saveFile2(@RequestParam String itemName,
                           @RequestParam MultipartFile file,
                           HttpServletRequest request) throws IOException {

        String mainDir = System.getProperty("user.dir") + fileMainDir;

        Path mainDirPath = Paths.get(mainDir);
        if(!Files.exists(mainDirPath))
            Files.createDirectories(mainDirPath);

        Path path = Paths.get(mainDir, file.getOriginalFilename());
        file.transferTo(path.toFile());

        return "upload-form";
    }
}
