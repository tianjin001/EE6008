package com.onlineLibrary.service;

import com.onlineLibrary.DTO.LoginDTO;
import com.onlineLibrary.VO.LoginVO;
import com.onlineLibrary.entity.User;

public interface LoginService {
     LoginVO login01(LoginDTO loginDTO);

     User selectByUsername(User user);

     void register01(User user);


}


