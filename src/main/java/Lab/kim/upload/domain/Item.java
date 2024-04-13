package Lab.kim.upload.domain;

import lombok.Data;

import java.util.List;

@Data
public class Item {
    private Long id;
    private String itemName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles; //여러개의 이미지 저장을 위해
}
