package com.onlineLibrary.service;

import com.onlineLibrary.DTO.UserDTO;
import com.onlineLibrary.VO.UserLoginVO;

public interface UserService {

    /**
     * 用户登录
     * @param userDTO
     * @return
     */
    UserLoginVO userlogin(UserDTO userDTO);
}
