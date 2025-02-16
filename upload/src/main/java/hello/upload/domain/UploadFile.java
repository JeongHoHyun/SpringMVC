package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile {

    private String uploadFileName;
    private String storeFileName;

    public UploadFile(String originalFileName, String storeFileName) {
        this.uploadFileName = originalFileName;
        this.storeFileName = storeFileName;
    }
}
