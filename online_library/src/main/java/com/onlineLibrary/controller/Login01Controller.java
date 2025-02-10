package com.onlineLibrary.controller;

import com.onlineLibrary.VO.LoginVO;
import com.onlineLibrary.constant.MessageConstant;
import com.onlineLibrary.result.Result;
import com.onlineLibrary.entity.User;
import com.onlineLibrary.service.Login01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.AccountNotFoundException;

@RestController
public class Login01Controller {
    @Autowired
    private Login01Service login01Service;

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("/login01")
    public Result<LoginVO> login01(@RequestBody User user) {
        String password = user.getPassword();
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));

        LoginVO loginVO =  login01Service.login01(user);

        if (loginVO!= null) {
           return Result.success(loginVO);
        }else{
           return Result.error("wrong username or password");
        }
    }

    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }

    /**
     * 普通用户注册
     * @param user
     * @return
     */
    @PostMapping("/register01")
    public Result register01(@RequestBody User user) {
        User user1 = login01Service.selectByUsername(user);
        if (user1 != null) {
            System.out.println("username:"+user1.getUsername()+"is existed");
            return Result.error("username is existed");
        }else{
            login01Service.register01(user);
            return Result.success(user);
        }
    }
}

