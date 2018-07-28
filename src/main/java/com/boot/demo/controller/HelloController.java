package com.boot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.demo.Resourse.GirlProperties;

@RestController
@RequestMapping("hello")
public class HelloController {
  //通过注解将GirlProperties注入
  @Autowired
  private GirlProperties gp;

  // 通过注解将application.yml配置文件中的cupSize注入
  @Value("${cupSize}")
  private String cupSize;

  @Value("${age}")
  private int age;
  @Value("${content}")
  private String content;

  @RequestMapping("/say")
  public String say() {
    System.out.println("hello qgj");
    //    "Hello Spring Boot qgj! boob--"+cupSize;
    return "Hello Spring --" + content;
  }

  /**
   * 二つURl→同じ内容を訪問
   * @return
   */
  @RequestMapping(value = { "/hi", "/he" })
  public String sayTwo() {
    System.out.println("hello qgj");
    //    "Hello Spring Boot qgj! boob--"+cupSize;
    return "Hello Spring --" + content;
  }

  /**
   *
   * get URL data
   * http://localhost:8080/boot/hello/sayId/35
   * @return
   */
  @RequestMapping(value = "/sayId/{id}", method = RequestMethod.GET)
  public String sayId(@PathVariable(value = "id") Integer id) {

    return "@PathVariable id : " + id;
  }

  /**
   * 伝統方式訪問
   * http://localhost:8080/hello/url/?id=115
   * @param id
   * @return
   */
//  @RequestMapping(value = "/url", method = RequestMethod.GET)
  @GetMapping("/url")
  public String urlId(@RequestParam(value="id",required=false,defaultValue="0") Integer id) {
    return "@RequestParam id : " + id;
  }

  @RequestMapping("/girl")
  public Object girlInfo() {

    return gp;
  }
}
