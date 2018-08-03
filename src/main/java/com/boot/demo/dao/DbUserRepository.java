package com.boot.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.demo.persistBean.DbUser;

/**
 * @author qiguangjie
 * CrudRepository和jpaRepository区别
 * https://www.cnblogs.com/nicuty/p/6265303.html
 *
 */
public interface DbUserRepository extends CrudRepository<DbUser, Integer> {
    /* 通过用户和密码获取用户信息*/
    public DbUser findByUserNameAndPassWd(String userName, String passWd);
    /* 通过用户名查找*/
    public DbUser findByUserName(String userName);
    /* 检查用户名是否存在*/
    public boolean existsByUserName(String userName);
}
