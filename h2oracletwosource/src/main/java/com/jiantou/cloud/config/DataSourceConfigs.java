package com.jiantou.cloud.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfigs {

    @Bean(name = "master")
    @ConfigurationProperties(prefix = "master.spring.datasource")
    public DataSource getDataSource1() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        return dataSourceBuilder.build();
    }

    @Bean(name = "slave")
    @ConfigurationProperties(prefix = "slave.spring.datasource")
    public DataSource getDataSource2() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        return dataSourceBuilder.build();

    }
}
