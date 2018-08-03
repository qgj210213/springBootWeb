package com.boot.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.demo.dao.DbUserListRepository;
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
    @Autowired
    private DbUserListRepository dbUserListRepository;

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
     * @param dbUser
     * 检查注册的用户 数据是否存在
     */
    public boolean checkUserNameExists(DbUser dbUser) {

        return dbUserRepository.existsByUserName(dbUser.getUserName());

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
    /**
     * @return
     * 查询所有用户
     */
    public List<DbUser> getUserList(DbUser dbUser){
        return dbUserListRepository.findAll();
    }
}
