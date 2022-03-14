package com.jta.source.controller;

import com.jta.source.service.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

@RestController
public class TransferController {

    @Resource
    private TransferService transferService ;

    @GetMapping("/transfer01")
    public String transfer01 () {
        transferService.transfer01();
        return "success" ;
    }

    @GetMapping("/transfer02")
    public String transfer02 () {
        transferService.transfer02();
        return "success" ;
    }
}
