package com.lt.tx;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 声明式事务
 *  环境搭建
 *      1.导入相关依赖
 *          数据源，数据库驱动，SpringJdbc模块
 *      2.配置数据源和JdbcTemplate(Spring 提供简化数据库操作的工具)操作数据
 *      3.给方法标注 @Transactional 说明该方法是一个事务方法
 *      4@EnableTransactionManagement 开启基于注解的事务管理功能
 *          @EnableXXXX
 *      5.配置事务管理器来控制事务
 *
 */
@EnableTransactionManagement
@ComponentScan("com.lt")
@Configuration
public class TxConfig {


    /**
     * 数据源
     * @return
     * @throws PropertyVetoException
     */
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate () throws PropertyVetoException {
        //Spring 对@Configuration 类会特殊处理;给容器中加组件的方法，多次调用都是从容器中找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    //注册事务管理器
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource());
        return dataSourceTransactionManager;
    }


}
