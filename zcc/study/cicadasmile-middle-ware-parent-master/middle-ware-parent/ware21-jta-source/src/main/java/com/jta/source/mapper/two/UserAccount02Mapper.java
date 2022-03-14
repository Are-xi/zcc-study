package com.jta.source.mapper.two;

import org.apache.ibatis.annotations.Param;

public interface UserAccount02Mapper {
    void transfer (@Param("name") String name, @Param("money") Integer money) ;
}
