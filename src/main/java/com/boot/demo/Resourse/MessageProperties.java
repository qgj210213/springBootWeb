package com.boot.demo.Resourse;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author qiguangjie
 * 自定义读取properties文件
 * 1.新建message.properties
 * 2.新建messageProperties.java
 *
 *
 */
@Configuration
@PropertySource("classpath:config/config.properties")
@ConfigurationProperties(prefix="header.address",ignoreUnknownFields = false)

@Data
@Component
public class MessageProperties {
  private String city;

}
