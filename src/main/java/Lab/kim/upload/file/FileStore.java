package Lab.kim.upload.file;


import Lab.kim.upload.domain.UploadFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
public class FileStore {
    @Value("${file.dir.image.main}")
    private String fileMainDir;

    @Value("${file.dir.image.sub}")
    private String fileSubDir;

    public String getFullPath(String fileName) {
        return System.getProperty("user.dir") + fileMainDir + fileName;
    }

    public List<UploadFile> storeFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<UploadFile> storeFileResult = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                storeFileResult.add(storeFile(multipartFile));
            }
        }
        return storeFileResult;
    }

    public UploadFile storeFile(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return null;
        }
        //실제 파일 이름
        String originalFilename = file.getOriginalFilename();

        //서버에 저장되는 파일 이름
        String storeFileName = createStoreFileName(originalFilename);

        Path mainDirPath = Paths.get(storeFileName);
        if (!Files.exists(mainDirPath)) {
            Files.createDirectories(mainDirPath);
        }
        file.transferTo(new File(getFullPath(storeFileName)));

        return new UploadFile(originalFilename, storeFileName);
    }

    private String createStoreFileName(String originalFilename) {
        String uuid = UUID.randomUUID().toString();
        String ext = extractExt(Objects.requireNonNull(originalFilename));
        return uuid + "." + ext;
        // storeFileName = 123+qweasgker+345346.png
    }

    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }
}
