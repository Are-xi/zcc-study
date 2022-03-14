package com.minio.file.controller;

import com.minio.file.service.UploadService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UploadController {

    @Resource
    private UploadService uploadService ;

    @GetMapping("/uploadHtml")
    public String uploadHtml() throws Exception {
        String fileName = "io-page.html";
        String filePath = "F:/min-io/io-page.html";
        return uploadService.uploadHtml(fileName,filePath);
    }

    @GetMapping("/uploadImg")
    public String uploadImg() throws Exception {
        String imgName = "io-img.jpg";
        String imgPath = "F:/min-io/io-img.jpg";
        return uploadService.uploadImg(imgName,imgPath);
    }

}
