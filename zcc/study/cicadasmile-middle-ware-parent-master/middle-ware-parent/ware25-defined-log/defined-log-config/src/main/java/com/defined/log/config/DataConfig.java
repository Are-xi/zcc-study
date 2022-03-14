package com.defined.log.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.defined.log.mapper")
@ComponentScan(basePackages = "com.defined.log")
public class DataConfig {

    @Bean(name = "DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public static DataSource logDataSource() {
        return new DruidDataSource() ;
    }

}
