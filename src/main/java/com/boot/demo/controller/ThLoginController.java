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

/**
 * @author qiguangjie
 * 实体dbUser
 * table db_user
 * 1.初期化登録画面表示
 * 2.画面注册
 * 3.初期化登録校验表示
 *
 *
 *
 */
@Controller
//@RestController
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
    * @param map
    * 初期化画面注册
    */
    @GetMapping("/regist")
    public String register(ModelMap map) {

        map.addAttribute("dbUser", new DbUser());
        map.addAttribute("message", new Message());
        return "thymeleaf/register";

    }

    /**
     * 画面注册
     * DbUser情報を追加
     * */
    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute(value = "dbUser") DbUser dbUser, ModelMap map) {
        String url = null;
        if (!userService.checkUserNameExists(dbUser)) {
            userService.insert(dbUser);
            map.addAttribute("dbUser", dbUser);
            message.reistInfo = "用户注册成功！";
            map.addAttribute("message", message);
            url = "thymeleaf/main";
        } else {
            message.reistInfo = "用户已经注册！";
            map.addAttribute("message", message);
            url = "thymeleaf/register";
        }

        return url;
    }

    /**
     * 初期化登録校验表示
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

            message.reistInfo = null;
            Url = "thymeleaf/main";

        } else {
            message.reistInfo = null;
            Url = "thymeleaf/loginUser";
        }
        map.addAttribute("dbUser", dbUser);
        map.addAttribute("message", message);

        return Url;

    }

    /**
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/list")
    public String getDbUserList(ModelMap modelMap,@ModelAttribute(value = "dbUser") DbUser dbUser) {
        modelMap.addAttribute("dbUsers", userService.getUserList(dbUser));
        return "thymeleaf/list";

    }
}
