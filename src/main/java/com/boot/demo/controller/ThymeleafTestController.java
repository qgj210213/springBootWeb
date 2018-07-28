package com.boot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.demo.Resourse.MessageProperties;

/**
 * 从spring boot默认的application.propertie或者自定义资源文件中获取数据
 * https://www.cnblogs.com/sxdcgaq8080/p/7659074.html
 * @author qiguangjie
 * thymeleaf tag test
 *
 */
@Controller
@RequestMapping("test")
@Configuration
@PropertySource("classpath:config/config.properties")
@EnableConfigurationProperties(MessageProperties.class)
public class ThymeleafTestController {
  @Autowired
  MessageProperties messageProperties;

  /**
   * ①===第一种方式：使用@ConfigurationProperties获取配置文件
   * @param modelMap
   * @return
   */
  @GetMapping(value = "/show")
  public String showProperties(ModelMap modelMap) {

    modelMap.addAttribute("city", messageProperties.getCity());
    return "thymeleaf/thymeLeafTag";
  }

  /**
   * ②===第二种方式：使用@Value获取配置文件
   * 定义资源文件需要满足application-{profile}.properties格式
   * @param modelMap
   * @return
   */
  @Value("${header.address.city}")
  private String city;

  @GetMapping(value = "/show2")
  public String showProperties2(ModelMap modelMap) {

    modelMap.addAttribute("city", city + "2");
    return "thymeleaf/thymeLeafTag";
  }

  /**
   * ③===第三种方式：使用Environment获取资源文件
   * @param modelMap
   * @return
   */
  @Autowired
  Environment environment;

  @GetMapping(value = "/show3")
  public String showProperties3(ModelMap modelMap) {

    modelMap.addAttribute("city", environment.getProperty("header.address.city") + "3");
    return "thymeleaf/thymeLeafTag";
  }

}
