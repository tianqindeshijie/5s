package com.chinamobile.iot.lightapp.mysql.config;

import com.github.pagehelper.PageHelper;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * MyBatis 配置类
 *
 * @author sxt
 * @create 2016/10/20
 */
@Configuration
@MapperScan("com.chinamobile.iot.lightapp.mysql.dao")
public class MyBatisConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(MyBatisConfiguration.class);
    @Bean
    public PageHelper pageHelper() {
        logger.info("Register the PageHelper of MyBatis");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        p.setProperty("pageSizeZero","true");
        p.setProperty("params","pageNum=pageHelperStart;pageSize=pageHelperRows;");
        pageHelper.setProperties(p);
        return pageHelper;
    }

}