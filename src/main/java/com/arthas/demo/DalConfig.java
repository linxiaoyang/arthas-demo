package com.arthas.demo;


import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 数据库持久化配置
 *
 * @author za-linyang
 * @date 2019/03/26
 */
@Configuration
@MapperScan("com.arthas.demo.dao")
@EnableTransactionManagement
public class DalConfig {


    @Value(value = "classpath:mybatis/sqlmap/*.xml")
    private Resource[] mapperLocations;

    @Value(value = "classpath:mybatis/mybatis-config.xml")
    private Resource configLocation;


    @Bean(autowire = Autowire.BY_NAME)
    public SqlSessionFactoryBean sqlSessionFactory() {
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        ssfb.setMapperLocations(mapperLocations);
        ssfb.setConfigLocation(configLocation);
        ssfb.setTypeAliasesPackage("com.arthas.demo.bean");
        return ssfb;
    }

    @Bean(initMethod = "init")
    public DruidDataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/user");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setMaxActive(120);
        druidDataSource.setInitialSize(1);
        druidDataSource.setMaxWait(60000);//60s
        druidDataSource.setMinIdle(1);
        druidDataSource.setTimeBetweenEvictionRunsMillis(300000);
        druidDataSource.setMinEvictableIdleTimeMillis(1800000);
        druidDataSource.setValidationQuery("select 1");
        druidDataSource.setTestWhileIdle(true);
        druidDataSource.setTestOnBorrow(false);
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        return druidDataSource;
    }

}
