package Lab.kim.upload.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

@Slf4j
@Controller
@RequestMapping("/servlet/v2")
public class ServletUploadControllerV2 {
    @Autowired
    private ResourceLoader resourceLoader;

    @Value("${file.dir.image.main}")
    private String fileMainDir;

    @Value("${file.dir.image.sub}")
    private String fielSubDir;


    @GetMapping("/upload")
    public String newFile() {
        return "upload-form";
    }

    @PostMapping("/upload")
    public String saveFileV2(HttpServletRequest request) throws ServletException, IOException {
        log.info("request={}", request);
        String itemName = request.getParameter("itemName");

        log.info("itemName={}", itemName);
        Collection<Part> parts = request.getParts();
        for (Part part : parts) {
            log.info("===============");
            log.info("name={}", part.getName());
            Collection<String> headerNames = part.getHeaderNames();
            for (String headerName : headerNames) {
                log.info("header{} : {}", headerName, part.getHeader(headerName));
            }
            log.info("submitted={}", part.getSubmittedFileName());
            log.info("size={}", part.getSize());

            // read data
            InputStream inputStream = part.getInputStream(); // 바이너리가 들어옴
            String body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
            log.info("body={}", body);
            //파일 저장하기
            if (StringUtils.hasText(part.getSubmittedFileName())) {
                String fullPath = fileMainDir + part.getSubmittedFileName();
                log.info("파일 저장 fullPath={}", fullPath);
                part.write(fullPath);
            }
        }
        log.info("parts={}", parts);


        return "upload-form";
    }
    public void saveFile(MultipartFile file) throws IOException {
        Resource fileResource = resourceLoader.getResource(fileMainDir);
        File fileDir = fileResource.getFile();
        log.info("fileDir={}", fileDir);
        file.transferTo(new File(fileDir, file.getOriginalFilename()));
    }
}

