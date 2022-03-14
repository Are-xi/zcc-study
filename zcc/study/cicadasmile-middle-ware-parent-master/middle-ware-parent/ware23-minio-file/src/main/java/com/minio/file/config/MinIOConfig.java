package com.minio.file.config;

import io.minio.MinioClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class MinIOConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(MinIOConfig.class) ;

    @Resource
    private ParamConfig paramConfig ;

    private MinioClient minioClient ;

    /**
     * 初始化 MinIO 客户端
     */
    @PostConstruct
    private void init(){
        try {
            minioClient = new MinioClient(paramConfig.getEndpoint(),
                                          paramConfig.getAccessKey(),
                                          paramConfig.getSecretKey());
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.info("MinIoClient init fail ...");
        }
    }

    /**
     * 上传 <html> 页面
     */
    public String uploadHtml (String fileName, String filePath) throws Exception {
        minioClient.putObject(paramConfig.getBucketNameHtml(),fileName,filePath);
        return paramConfig.getEndpoint()+"/"+paramConfig.getBucketNameHtml()+"/"+fileName ;
    }

    /**
     * 上传 <img> 图片
     */
    public String uploadImg (String imgName, String imgPath) throws Exception {
        minioClient.putObject(paramConfig.getBucketNameImage(),imgName,imgPath);
        return paramConfig.getEndpoint()+"/"+paramConfig.getBucketNameImage()+"/"+imgName ;
    }
}
