package com.boot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * SpringBoot如何配置和引用国际化资源
 * @author qiguangjie
 * 在Java代码中引用国际化文件
 * 1.首先注入MessageSource
 * 2.然后通过LocaleContextHolder.getLocale()来获取当前Locale
 * 3.最后通messageSource.getMessage("hello.world", null,locale)来去对应的国际化资源文件中取消息。
 * #国际化资源文件
 * messages:
 *   basename: i18n/messages/messages
 *
 */
@Controller
@RequestMapping(value = "i18n")
public class InternationalRresourcesController {
  @Autowired
  MessageSource messageSource;

  @RequestMapping(value = "hello")
  public String getInternational() {
//    Locale locale = LocaleContextHolder.getLocale();
//    String msg = messageSource.getMessage("hello.world", null, locale);
//    System.out.println("locale:"+locale.toString()+"--Msg:" +msg);
    return "thymeleaf/internationalRresources";

  }

}
