package com.busanit501.ngylunchproject.controller;

import com.busanit501.ngylunchproject.dto.upload.UploadFileDTO;
import com.busanit501.ngylunchproject.dto.upload.UploadResultDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Log4j2
public class UpDownController {
    @Value("${com.busanit501.upload.path}")
    private String uploadPath;
//swagger 배신으로 인해 잠시 사용 중지
//    @Tag(name = "파일 업로드 post 방식", description = "파일 업로드 post 방식")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public List<UploadResultDTO> upload(UploadFileDTO uploadFileDTO) {
        log.info("updown controller_uploadfile 확인 : "+uploadFileDTO);

        if(uploadFileDTO.getFiles() != null) {
            //임시로 저장
            final List<UploadResultDTO> imgList = new ArrayList<>();


            uploadFileDTO.getFiles().forEach(multipartFile -> {
                log.info("파일명 확인: "+multipartFile.getOriginalFilename());

                String originName = multipartFile.getOriginalFilename(); //원본 파일명
                String uuid = UUID.randomUUID().toString(); //랜덤한 16자리 문자열
                Path savePath = Paths.get(uploadPath, uuid + "_" + originName);
                boolean imgCheck = false;

                try {
                    //실제 파일에 저장
                    multipartFile.transferTo(savePath);

                    //해당 파일의 종류를 확인후, 타입 image/*로 시작한다면, 썸네일로 변경
                    if(Files.probeContentType(savePath).startsWith("image")) {
                        imgCheck = true;
                        File thumbFile = new File(uploadPath, "s_"+uuid + "_" + originName);
                        Thumbnailator.createThumbnail(savePath.toFile(),thumbFile,200,200);
                    }
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

                UploadResultDTO uploadResultDTO = UploadResultDTO.builder()
                        .uuid(uuid)
                        .fileName(originName)
                        .imgCheck(imgCheck)
                        .build();

                imgList.add(uploadResultDTO);
            });
            return imgList;
        }
        //사진이 없는 경우 null 리턴
        return null;
    }

    @GetMapping(value = "/view/{fileName}")
    public ResponseEntity<Resource> getViewFile(@PathVariable String filename) {
        // c:\\upload\\springTest\\이미지파일명, 접근하는 객체
        Resource resource = new FileSystemResource(uploadPath + File.pathSeparator+filename);

        String resourceName = resource.getFilename();
        HttpHeaders headers = new HttpHeaders();

        try{
            headers.add("Content-Type", Files.probeContentType(resource.getFile().toPath()));

        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok().headers(headers).body(resource);
    }

    

}
