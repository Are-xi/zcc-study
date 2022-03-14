package com.minio.file.service;

import com.minio.file.config.MinIOConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UploadServiceImpl implements UploadService {

    @Resource
    private MinIOConfig minIOConfig ;

    // 上传 <html> ,返回服务器地址
    @Override
    public String uploadHtml(String fileName, String filePath) throws Exception {
        return minIOConfig.uploadHtml(fileName,filePath);
    }

    // 上传 <img> ,返回服务器地址
    @Override
    public String uploadImg(String imgName, String imgPath) throws Exception {
        return minIOConfig.uploadImg(imgName,imgPath);
    }
}
