package org.dkwork.javatemplate.config;//package com.taiji.tjhall.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jin
 * @date 2020/8/27
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProjecet tj-hall
 * @BelongPackage com.taiji.tjhall.config
 * @Describe:
 */
@Configuration
public class AdditionalConfig {
    /**接口中，自动转换的有：驼峰转换为下划线，空值输出null*/
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer customJackson() {
        return jacksonObjectMapperBuilder -> {
            jacksonObjectMapperBuilder.serializationInclusion(JsonInclude.Include.NON_NULL);
            jacksonObjectMapperBuilder.failOnUnknownProperties(false);
            jacksonObjectMapperBuilder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        };
    }
}
