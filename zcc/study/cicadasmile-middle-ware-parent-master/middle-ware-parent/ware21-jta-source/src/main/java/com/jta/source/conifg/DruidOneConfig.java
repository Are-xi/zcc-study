package com.jta.source.conifg;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.jta.source.mapper.one"},sqlSessionTemplateRef = "data01SqlSessionTemplate")
public class DruidOneConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DruidOneConfig.class) ;

    @Resource
    private DruidOneParam druidOneParam ;

    @Primary
    @Bean("dataSourceOne")
    public DataSource dataSourceOne () {

        // 设置数据库连接
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(druidOneParam.getDbUrl());
        mysqlXADataSource.setUser(druidOneParam.getUsername());
        mysqlXADataSource.setPassword(druidOneParam.getPassword());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        // 事务管理器
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("dataSourceOne");
        return atomikosDataSourceBean;
    }

    @Primary
    @Bean(name = "sqlSessionFactoryOne")
    public SqlSessionFactory sqlSessionFactoryOne(
            @Qualifier("dataSourceOne") DataSource dataSourceOne) throws Exception{
        // 配置Session工厂
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSourceOne);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:/dataOneMapper/*.xml"));
        return sessionFactory.getObject();
    }

    @Primary
    @Bean(name = "data01SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactoryOne") SqlSessionFactory sqlSessionFactory) {
        // 配置Session模板
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
