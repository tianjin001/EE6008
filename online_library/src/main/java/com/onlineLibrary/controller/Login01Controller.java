package com.onlineLibrary.controller;

import com.onlineLibrary.pojo.LoginInfo;
import com.onlineLibrary.pojo.Result;
import com.onlineLibrary.pojo.User;
import com.onlineLibrary.service.Login01Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login01Controller {
    @Autowired
    private Login01Service login01Service;

    @PostMapping("/login01")
    public Result login01(@RequestBody User user) {
           LoginInfo info=  login01Service.login01(user);
           if (info != null) {
               return Result.success(info);
           }else{
                return Result.error("wrong username or password");
           }
    }

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

