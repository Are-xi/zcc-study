package com.jta.source.mapper.one;

import org.apache.ibatis.annotations.Param;

public interface UserAccount01Mapper {
    void transfer (@Param("name") String name, @Param("money") Integer money) ;
}
