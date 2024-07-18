package com.jolipjo.lovebridge.common;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.ObjectMetadata;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;


/*
* 파일 업로드 기능.
* 사용법:
* 1. 컨트롤러에서 MultipartFile 형태로 파일을 받는다.(타임리프 파일 업로드)
* 2. saveFile() 메소드 호출
* 3. 반환 URL을 DB에 저장함
* */
@Service
public class FileUploader {

    private final AmazonS3 amazonS3;
    private Set<String> uploadedFileNames = new HashSet<>();
    private Set<Long> uploadedFileSizes = new HashSet<>();

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Value("${spring.servlet.multipart.max-file-size}")
    private String maxSizeString;

    public FileUploader(AmazonS3 amazonS3) {
        this.amazonS3 = amazonS3;
    }

    // 여러장의 파일 저장
    public List<String> saveFiles(List<MultipartFile> multipartFiles) {
        List<String> uploadedUrls = new ArrayList<>();

        for (MultipartFile multipartFile : multipartFiles) {

            if (isDuplicate(multipartFile)) {
                throw new RuntimeException("이미지 중복!");
            }

            String uploadedUrl = saveFile(multipartFile);
            uploadedUrls.add(uploadedUrl);
        }

        clear();
        return uploadedUrls;
    }

    // 파일 삭제
    public void deleteFile(String fileUrl) {
        String[] urlParts = fileUrl.split("/");
        String fileBucket = urlParts[2].split("\\.")[0];

        if (!fileBucket.equals(bucket)) {
            throw new RuntimeException("삭제할 이미지가 없습니다.");
        }

        String objectKey = String.join("/", Arrays.copyOfRange(urlParts, 3, urlParts.length));

        if (!amazonS3.doesObjectExist(bucket, objectKey)) {
            throw new RuntimeException("삭제할 이미지가 없습니다.");
        }

        try {
            amazonS3.deleteObject(bucket, objectKey);
        } catch (AmazonS3Exception e) {
            
            throw new RuntimeException("이미지 삭제 실패");
        } catch (SdkClientException e) {
            throw new RuntimeException("sdk 오류로 이미지 삭제 실패");
        }
        
    }

    // 단일 파일 저장
    public String saveFile(MultipartFile file) {
        String randomFilename = generateRandomFilename(file);

        

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        try {
            amazonS3.putObject(bucket, randomFilename, file.getInputStream(), metadata);
        } catch (AmazonS3Exception e) {
            
            throw new RuntimeException("ErrorMessage.FAIL_UPLOAD");
        } catch (SdkClientException e) {
            
            throw new RuntimeException("ErrorMessage.FAIL_UPLOAD");
        } catch (IOException e) {
            
            throw new RuntimeException("ErrorMessage.FAIL_UPLOAD");
        }

        return amazonS3.getUrl(bucket, randomFilename).toString();
    }

    // 요청에 중복되는 파일 여부 확인
    private boolean isDuplicate(MultipartFile multipartFile) {
        String fileName = multipartFile.getOriginalFilename();
        Long fileSize = multipartFile.getSize();

        if (uploadedFileNames.contains(fileName) && uploadedFileSizes.contains(fileSize)) {
            return true;
        }

        uploadedFileNames.add(fileName);
        uploadedFileSizes.add(fileSize);

        return false;
    }

    private void clear() {
        uploadedFileNames.clear();
        uploadedFileSizes.clear();
    }

    // 랜덤파일명 생성 (파일명 중복 방지)
    private String generateRandomFilename(MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        String fileExtension = validateFileExtension(originalFilename);
        String randomFilename = UUID.randomUUID() + "." + fileExtension;
        return randomFilename;
    }

    // 파일 확장자 체크
    private String validateFileExtension(String originalFilename) {
        String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
        List<String> allowedExtensions = Arrays.asList("jpg", "png", "gif", "jpeg");

        if (!allowedExtensions.contains(fileExtension)) {
            throw new RuntimeException("파일이 없습니다.");
        }
        return fileExtension;
    }
}
