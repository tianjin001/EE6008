package com.onlineLibrary.service.impl;

import com.onlineLibrary.mapper.UserMapper;
import com.onlineLibrary.VO.LoginVO;
import com.onlineLibrary.entity.User;
import com.onlineLibrary.service.Login01Service;
import com.onlineLibrary.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class Login01ServiceImpl implements Login01Service {
    @Autowired
    private UserMapper userMapper;

    @Override
    public LoginVO login01(User user){
         User user1 = userMapper.select(user);
         if(user1 != null){
             Map<String,Object> claims = new HashMap<>();
             claims.put("id",user1.getId());
             String jwt = JwtUtils.generateJwt(claims);
             return new LoginVO(user1.getId(),user1.getUsername(),user1.getName(),jwt);
         }else {
             return null;
         }
    }
    //user.getUsername(), user.getPassword()

    @Override
    public User selectByUsername(User user) {
        return userMapper.selectByCondition(user.getUsername());
    }

    @Override
    public void register01(User user) {
        userMapper.add(user);
    }


}
