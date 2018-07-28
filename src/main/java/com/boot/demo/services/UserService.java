package com.boot.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.demo.dao.DbUserRepository;
import com.boot.demo.persistBean.DbUser;

/**
 * @author qiguangjie
 * ユーザー業務層
 * ロジック
 *
 */
@Service
public class UserService {
  @Autowired
  private DbUserRepository dbUserRepository;

  /**
   * @param dbUser
   * User情報を追加
   */
  @Transactional
  public void insert(DbUser dbUser) {
    DbUser User = new DbUser();
    User.setUserName(dbUser.getUserName());
    User.setPassWd(dbUser.getPassWd());
    User.setEmail(dbUser.getEmail());
    User.setTelephone(dbUser.getTelephone());
    dbUserRepository.save(User);
  }

  /**
   * 检验输入的用户名和密码是否一致
   * @param dbUser
   * @return
   */
  public String checkUserNameAndPwd(DbUser dbUser) {

    DbUser user = dbUserRepository.findByUserNameAndPassWd(dbUser.getUserName(),
        dbUser.getPassWd());
    if (null == user) {

      return "NG";
    }

    return "OK";
  }
}
