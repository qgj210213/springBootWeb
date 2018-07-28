package com.boot.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "th")
public class thymeleafController {

  @GetMapping(value = "/hello")
  public String hello(ModelMap map) {

    map.addAttribute("usrName", "dalian-qgj");
    System.out.println("userName--qgj");
    return "thymeleaf/hello";
  }

}
