package com.boot.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.demo.persistBean.PostBean;

@RestController
@RequestMapping("test")
public class PostController {
    Logger logger = LoggerFactory.getLogger(PostController.class);

    @GetMapping("/index")
    public String index() {
        return "Greetings from Spring Boot sss!";
    }

    @PostMapping("/post")
    public Object getPostInfo(@ModelAttribute(value = "orderNum") String orderNum) {
        PostBean post = new PostBean();
        post.setCode("S00"+orderNum);
        post.setCodeName("大阪支店");
        return post;
    }

    /*@PostMapping("/post2")
    public Object getPostInfo2(@RequestBody JSONObject params) {
        String orderNum = params.getString("orderNum").concat("qgj");
        return orderNum;
    }*/

    @GetMapping("/get")
    public String getPostInfo2(@ModelAttribute(value = "orderNum") String orderNum) {
        orderNum = orderNum.concat("get-qgj");
        return orderNum;
    }

    @GetMapping(value = "/add")
    public List<String> test() {

        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        return list;
    }

}
