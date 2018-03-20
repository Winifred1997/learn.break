package com.learn.api.configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by kevinzou on 4/1/17.
 * DataSourceConfig
 * 多数据源配置
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "myselfDataSource")
    @Primary
    @Qualifier("myselfDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid")
    public DataSource myselfDataSource() {
        return DruidDataSourceBuilder.create().build();
    }

}
