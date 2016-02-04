package com.wilhelmina.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * Created by skandula on 2/3/16.
 */
@Configuration

public class AppConfig {
    @Autowired
    Environment env;

    public String getProperty(String key) {
        return env.getProperty(key);
    }
}