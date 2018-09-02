package com.boot.demo.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.boot.demo.persistBean.ObjectBean;

/**
 * 通过@Repository注解标注该类为持久化操作对象
 */
@Repository
public class CustomObjectRepository {
    // 通过@Resource注解引入JdbcTemplate对象
    @Resource
    private JdbcTemplate jdbcTemplate;

    /**
     * 使用JdbcTemplate查询数据步骤:
     * 1. 定义一个sql语句
     * 2. 定义一个RowMapper
     * 3. 执行查询方法
     */

    public List<ObjectBean> selectCarts() {
        // 1. 定义一个sql语句
        String sql = "select  car.PRODUCT_NAME from  db_cart car left join db_user usr  on car.USER_ID = usr.id  left join db_product pt on car.PRODUCT_ID = pt.product_id";
        // 2. 定义一个RowMapper
        RowMapper<ObjectBean> rowMapper = new BeanPropertyRowMapper<ObjectBean>(ObjectBean.class);

        List<ObjectBean> objList = jdbcTemplate.query(sql, rowMapper);
        return objList;
    }
}
