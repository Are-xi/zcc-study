package com.page.statics.controller;

import com.page.statics.service.PageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PageController {

    @Resource
    private PageService pageService ;

    @GetMapping("/ftlToHtml")
    public String ftlToHtml () throws Exception {
        pageService.ftlToHtml();
        return "success" ;
    }
}
