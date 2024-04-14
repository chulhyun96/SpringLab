package Lab.kim.upload.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class UploadFile {

    /*uploadFileName: 이 이름은 사용자가 파일을 업로드할 때 사용한 원본 파일 이름입니다. 보통 사용자가 파일을 선택하면 그 파일의 이름이 'uploadFileName'이 됩니다. 예를 들어, 사용자가 'myphoto.jpg'라는 이름의 사진을 업로드하면 'uploadFileName'은 'myphoto.jpg'가 됩니다.
    storeFileName: 이 이름은 서버에 파일이 저장될 때 사용하는 실제 파일 이름입니다. 서버는 종종 업로드된 파일을 구별하기 위해 또는 시스템에 따라서 새로운 이름을 부여할 수 있습니다. 예를 들어, 중복을 피하거나 파일 관리를 쉽게 하기 위해 '123456789.jpg'와 같은 형식으로 저장할 수 있습니다.
    이때, 원본 파일 이름과 저장된 파일 이름을 모두 추적하면 사용자에게는 원래 이름대로 파일을 보여주면서, 한편으로는 서버 안에서 효과적으로 파일을 관리할 수 있게 됩니다. 이 둘을 분리해두면, 원본 파일 이름을 알고 있는 경우에도 서버에서 실제 파일을 찾기 어렵게 만들어 데이터의 보안성을 높이는 이점도 있습니다.*/

    // 고객이 업로드한 파일명으로 서버 내부에 파일을 저장하면 안됨.
    // 왜냐면 서로 다른 고객이 같은 파일이름을 업로드 하는 경우 기존 파일 이름과 충돌이 날 수 있다.
    // 서버에서는 저장할 파일명이 겹치지 않도록 내부에서 관리하는 별도의 파일명이 필요하다.


    // 클라이언트가 업로드한 파일 명
    private String uploadFileName;

    // 서버 내부에서 관리하는 파일 명
    private String storeFileName;

    public UploadFile(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
