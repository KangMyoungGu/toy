package com.example.toy.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class DatabaseConfig {
   /* @Autowired ApplicationContext applicationContext;

    @Primary
    @Bean
    public DataSource dataSource() {
        BasicDataSource ds = new BasicDataSource();

        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://192.168.35.39:3306/toy?characterEncoding=UTF-8&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("rjan2710");

        ds.setDefaultAutoCommit(false);

        return ds;
    }

    @Primary
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource ds) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds);
        factoryBean.setConfigLocation(applicationContext.getResource("classpath:/mybatis/mybatis-config.xml"));
        factoryBean.setMapperLocations(applicationContext.getResources("classpath:/mybatis/sql/*.xml"));

        return factoryBean.getObject();
    }

    @Primary
    @Bean
    public SqlSessionTemplate sqlSession(SqlSessionFactory sf) {
        return new SqlSessionTemplate(sf);
    }

    @Primary
    @Bean
    public DataSourceTransactionManager transactionManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }*/
}
