package com.page.statics.service.impl;

import com.page.statics.entity.Constant;
import com.page.statics.entity.TableInfo;
import com.page.statics.service.PageService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PageServiceImpl implements PageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageServiceImpl.class) ;
    private static final String PATH = "/templates/" ;

    @Override
    public void ftlToHtml() throws Exception {
        // 创建配置类
        Configuration configuration = new Configuration(Configuration.getVersion());
        // 设置模板路径
        String classpath = this.getClass().getResource("/").getPath();
        configuration.setDirectoryForTemplateLoading(new File(classpath + PATH));
        // 加载模板
        Template template = configuration.getTemplate("my-page.ftl");
        // 数据模型
        Map<String, Object> map = new HashMap<>();
        map.put("myTitle", "页面静态化(PageStatic)");
        map.put("tableList",getList()) ;
        List<String> imgList = new ArrayList<>() ;
        imgList.add("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2855019356,2480789918&fm=26&gp=0.jpg") ;
        imgList.add("https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2293167576,2487413165&fm=26&gp=0.jpg") ;
        map.put("imgList",imgList) ;
        // 静态化页面内容
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        LOGGER.info("content:{}",content);
        InputStream inputStream = IOUtils.toInputStream(content,"UTF-8");
        // 输出文件
        FileOutputStream fileOutputStream = new FileOutputStream(new File("F:/web-page/newPage.html"));
        IOUtils.copy(inputStream, fileOutputStream);
        // 关闭流
        inputStream.close();
        fileOutputStream.close();
    }

    private List<TableInfo> getList (){
        List<TableInfo> tableInfoList = new ArrayList<>() ;
        tableInfoList.add(new TableInfo(Constant.desc1, Constant.img01));
        tableInfoList.add(new TableInfo(Constant.desc2,Constant.img02));
        return tableInfoList ;
    }
}
