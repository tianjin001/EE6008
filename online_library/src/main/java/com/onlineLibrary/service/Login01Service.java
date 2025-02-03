package com.onlineLibrary.service;

import com.onlineLibrary.pojo.LoginInfo;
import com.onlineLibrary.pojo.User;

public interface Login01Service {
     LoginInfo login01(User user);

     User selectByUsername(User user);

     void register01(User user);


}


