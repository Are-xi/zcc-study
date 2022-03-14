package com.minio.file.service;

public interface UploadService {

    String uploadHtml (String fileName, String filePath) throws Exception ;

    String uploadImg (String imgName, String imgPath) throws Exception ;

}
