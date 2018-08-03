package com.boot.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.demo.persistBean.DbUser;

public interface DbUserListRepository extends JpaRepository<DbUser, Integer> {
    public List<DbUser> findByUserNameLike(String userName);
}
