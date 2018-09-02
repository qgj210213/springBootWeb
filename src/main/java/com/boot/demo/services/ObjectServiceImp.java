package com.boot.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.demo.dao.CustomObjectRepository;
import com.boot.demo.persistBean.ObjectBean;

@Service
public class ObjectServiceImp implements ObjectService {
    @Autowired
    private CustomObjectRepository reposty;

    @Override
    public List<ObjectBean> getObjectList() {

        return reposty.selectCarts();
    }

}
