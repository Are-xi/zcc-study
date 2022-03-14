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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.jta.source.mapper.two"},sqlSessionTemplateRef = "data02SqlSessionTemplate")
public class DruidTwoConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DruidTwoConfig.class) ;
    @Resource
    private DruidTwoParam druidTwoParam ;

    @Bean("dataSourceTwo")
    public DataSource dataSourceTwo () {
        // 设置数据库连接
        MysqlXADataSource mysqlXADataSource = new MysqlXADataSource();
        mysqlXADataSource.setUrl(druidTwoParam.getDbUrl());
        mysqlXADataSource.setUser(druidTwoParam.getUsername());
        mysqlXADataSource.setPassword(druidTwoParam.getPassword());
        mysqlXADataSource.setPinGlobalTxToPhysicalConnection(true);

        // 事务管理器
        AtomikosDataSourceBean atomikosDataSourceBean = new AtomikosDataSourceBean();
        atomikosDataSourceBean.setXaDataSource(mysqlXADataSource);
        atomikosDataSourceBean.setUniqueResourceName("dataSourceTwo");
        return atomikosDataSourceBean;
    }

    @Bean(name = "sqlSessionFactoryTwo")
    public SqlSessionFactory sqlSessionFactoryOne(
            @Qualifier("dataSourceTwo") DataSource dataSourceTwo) throws Exception{
        // 配置Session工厂
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSourceTwo);
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath*:/dataTwoMapper/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean(name = "data02SqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(
            @Qualifier("sqlSessionFactoryTwo") SqlSessionFactory sqlSessionFactoryTwo) {
        // 配置Session模板
        return new SqlSessionTemplate(sqlSessionFactoryTwo);
    }

}
