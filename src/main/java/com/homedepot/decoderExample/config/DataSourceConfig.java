package com.homedepot.decoderExample.config;

import org.json.JSONObject;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ConfigurationProperties(prefix="database")
public class DataSourceConfig {

    private String url, user, driver;

    @Bean
    JSONObject dataSourceProps() {
        JSONObject props = new JSONObject();
        props.put("user", this.getUser());
        props.put("url", this.getUrl());
        props.put("driver", this.getDriver());
        return props;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }


}
