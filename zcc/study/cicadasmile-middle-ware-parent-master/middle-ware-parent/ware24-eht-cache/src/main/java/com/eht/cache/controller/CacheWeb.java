package com.eht.cache.controller;

import com.eht.cache.entity.UserEntity;
import com.eht.cache.service.CacheService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CacheWeb {

    @Resource
    private CacheService cacheService ;

    @GetMapping("/getById")
    public UserEntity getById (Integer id){
        return cacheService.getById(id) ;
    }

    @GetMapping("/updateUser")
    public String updateUser() {
        cacheService.updateUser(1);
        return "success" ;
    }
}
