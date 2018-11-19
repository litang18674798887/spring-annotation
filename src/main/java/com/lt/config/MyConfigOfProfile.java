package com.lt.config;

import com.lt.bean.Yellow;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringValueResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile
 *      Spring为我们提供的可以根据当前环境动态的激活和切换一系列组件的功能
 *
 *
 *  开发环境。测试环境，生产环境
 *  数据源：（/A) (/B)(/C)
 *
 *
 * @Profile 指定组件在哪个环境的情况下才能被注册到容器中，不指定任何环境下都能注册这个组件
 *          1.加了环境标志的bean，只有这个环境被激活的时候才能注册到容器中，默认是default环境
 *          2.写在配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 *          3.没有标注的环境标志的bean，在任何环境都是加载的
 *
 *
 */
@Profile("test")
@PropertySource("classpath:/dbconfig.properties")
@Configuration
public class MyConfigOfProfile  implements EmbeddedValueResolverAware {

    @Value("${db.user}")
    private String user;

    private StringValueResolver resolver;

    private String DriverClass;

    @Profile("test")
    @Bean
    public Yellow yellow(){

        return new Yellow();
    }


    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setDriverClass(DriverClass);
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/world");
        dataSource.setDriverClass(DriverClass);
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd(@Value("${db.password}") String pwd) throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(pwd);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/mysql");
        dataSource.setDriverClass(DriverClass);
        return dataSource;
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {

        this.resolver = resolver;
        DriverClass = resolver.resolveStringValue("${db.driverClass}");
    }
}
