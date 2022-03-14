package com.jta.source.service;

import com.jta.source.mapper.one.UserAccount01Mapper;
import com.jta.source.mapper.two.UserAccount02Mapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;

@Service
public class TransferServiceImpl implements TransferService {

    @Resource
    private UserAccount01Mapper userAccount01Mapper ;

    @Resource
    private UserAccount02Mapper userAccount02Mapper ;

    @Override
    public void transfer01() {
        userAccount01Mapper.transfer("jack",100);
        System.out.println("i="+1/0);
        userAccount02Mapper.transfer("tom",100);
    }

    @Transactional
    @Override
    public void transfer02() {
        userAccount01Mapper.transfer("jack",200);
        System.out.println("i="+1/0);
        userAccount02Mapper.transfer("tom",200);
    }
}
