package com.boot.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.demo.persistBean.Girl;

public interface GirlRepository extends JpaRepository<Girl, Integer> {

  // 通过年龄查询
  public List<Girl> findByAge(Integer age);

}
