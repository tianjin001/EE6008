package com.onlineLibrary.controller.user;


import com.onlineLibrary.DTO.StaffDTO;
import com.onlineLibrary.DTO.UserDTO;
import com.onlineLibrary.VO.StaffLoginVO;
import com.onlineLibrary.VO.UserLoginVO;
import com.onlineLibrary.entity.User;
import com.onlineLibrary.result.Result;
import com.onlineLibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @param userDTO
     * @return
     */
    @PostMapping("/login")
    public Result<UserLoginVO> userlogin(@RequestBody UserDTO userDTO) {

        String password = userDTO.getPassword();
        userDTO.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));

        UserLoginVO userLoginVO =  userService.userlogin(userDTO);

        if (userLoginVO != null) {
            return Result.success(userLoginVO);
        }else{
            return Result.error("wrong username or password");
        }
    }
}
