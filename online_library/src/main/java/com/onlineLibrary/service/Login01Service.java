package com.onlineLibrary.service;

import com.onlineLibrary.VO.LoginVO;
import com.onlineLibrary.entity.User;

public interface Login01Service {
     LoginVO login01(User user);

     User selectByUsername(User user);

     void register01(User user);


}


