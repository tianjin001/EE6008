package com.onlineLibrary.controller;

import com.onlineLibrary.DTO.LoginDTO;
import com.onlineLibrary.VO.LoginVO;
import com.onlineLibrary.entity.User;
import com.onlineLibrary.result.Result;
import com.onlineLibrary.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     * 登录
     * @param loginDTO
     * @return
     */
    @PostMapping("/login")
    public Result<LoginVO> login01(@RequestBody LoginDTO loginDTO) {

        String password = loginDTO.getPassword();
        loginDTO.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));

        LoginVO loginVO =  loginService.login01(loginDTO);

        if (loginVO != null) {
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
        User user1 = loginService.selectByUsername(user);
        if (user1 != null) {
            System.out.println("username:"+ user1.getUsername()+"is existed");
            return Result.error("username is existed");
        }else{
            loginService.register01(user);
            return Result.success(user);
        }
    }
}

