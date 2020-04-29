package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")  //自定义了springdatesource为druiddatasource
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }
    @Bean
    public ServletRegistrationBean a(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        //后台需要别人登陆
        HashMap<String ,String> initParameters=new HashMap<>();
        //bean.addUrlMappings();

        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123456");

        //允许谁访问
        initParameters.put("allow","");
        bean.setInitParameters(initParameters);
        return bean;
    }
    @Bean
    public FilterRegistrationBean webStatFileter(){
        FilterRegistrationBean bean =new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());
        //可以过滤的请求
        Map<String, String> initParameters =new HashMap<>();
        initParameters.put("exclusions","*.js,*.css,/druid/*");//这些不进行统计
        bean.setInitParameters(initParameters);
        return bean;
    }
}
