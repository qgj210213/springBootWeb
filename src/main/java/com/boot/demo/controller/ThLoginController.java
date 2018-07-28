package com.boot.demo.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.boot.demo.Resourse.Message;
import com.boot.demo.persistBean.DbUser;
import com.boot.demo.services.UserService;

@Controller
@RequestMapping(value = "th")
public class ThLoginController {
  @Autowired
  private Message message;

  @Autowired
  private UserService userService;

  /**
   * 初期化登録画面表示
   */
  @GetMapping("/init")
  public String init(ModelMap map) {

    map.addAttribute("dbUser", new DbUser());
    map.addAttribute("message", new Message());
    return "thymeleaf/loginUser";

  }

  /**
   * 画面注册
   * DbUser情報を追加
   * */
  @PostMapping(value = "/add")
  public String addUser(@ModelAttribute(value = "dbUser") DbUser dbUser, ModelMap map) {

    userService.insert(dbUser);
    map.addAttribute("dbUser", dbUser);
    map.addAttribute("message", message);
    return "thymeleaf/main";
  }

  /**
   * 初期化登録画面表示
   */
  @PostMapping("/login")
  public String loginIn(@ModelAttribute(value = "dbUser") DbUser dbUser, ModelMap map) {
    String Url = StringUtils.EMPTY;
    /*
     * 1.ユーザーはqgj210 && パスワードは1234の場合　主画面表示
     * 以上と違いのログインも一度登録。
     * */
    String status = userService.checkUserNameAndPwd(dbUser);
    if ("OK".equals(status)) {

      Url = "thymeleaf/main";
    } else {

      Url = "thymeleaf/loginUser";
    }
    map.addAttribute("dbUser", dbUser);
    map.addAttribute("message", message);

    return Url;

  }
}
