package com.boot.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.boot.demo.persistBean.DbUser;

public interface DbUserRepository extends CrudRepository<DbUser, Integer> {
  /*通过用户和密码获取用户信息*/
  public DbUser findByUserNameAndPassWd(String userName, String passWd);

}
