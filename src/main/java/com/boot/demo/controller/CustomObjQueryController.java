package com.boot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.demo.persistBean.ObjectBean;
import com.boot.demo.services.ObjectServiceImp;

/**
 * 1.自定义实体类ObjectBean
 * 2.数据库中设定两个表
 * 3.设置一个接口CustomObjectRepository
 * @author qiguangjie
 *
 */
@RestController
@RequestMapping("ob")
public class CustomObjQueryController {
    @Autowired
    private ObjectServiceImp serviceImp;
    @GetMapping(value="/car")
    public Object getProducts() {
        List<ObjectBean> objs = serviceImp.getObjectList();
        return objs;
    }

}
