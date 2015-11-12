package com.jersey.config;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.stereotype.Component;

@Component
public class SpringNamingStrategy extends ImprovedNamingStrategy {

    @Override
    public String tableName(String tableName) {
        return super.tableName(tableName);
    }

    @Override
    public String classToTableName(String className) {
        return super.classToTableName(className.split("Entity")[0]);
    }
}

