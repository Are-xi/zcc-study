package com.eht.cache.service;

import javax.annotation.Resource;
import com.eht.cache.entity.UserEntity;
import com.eht.cache.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheService.class);

    @Resource
    private UserMapper userMapper ;

    @Cacheable(value="userEntity")  // 在缓存有效期内，首次查询才访问数据库
    public UserEntity getById (Integer id){
        // 通过日志，标识方法是否执行
        LOGGER.info("getById..."+id);
        return userMapper.selectById(id) ;
    }

    @CacheEvict(value="userEntity",key = "#id") //该ID数据更新，清空该ID缓存
    public void updateUser(Integer id) {
        UserEntity user = new UserEntity() ;
        user.setId(id);
        user.setUserName("myCache");
        userMapper.updateById(user);
    }
}
