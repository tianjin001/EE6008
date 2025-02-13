package com.onlineLibrary.service.impl;

import com.onlineLibrary.DTO.StaffDTO;
import com.onlineLibrary.DTO.UserDTO;
import com.onlineLibrary.VO.StaffLoginVO;
import com.onlineLibrary.VO.UserLoginVO;
import com.onlineLibrary.entity.Staff;
import com.onlineLibrary.entity.User;
import com.onlineLibrary.mapper.StaffMapper;
import com.onlineLibrary.mapper.UserMapper;
import com.onlineLibrary.service.AdminService;
import com.onlineLibrary.service.UserService;
import com.onlineLibrary.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 用户登录
     * @param userDTO
     * @return
     */
    @Override
    public UserLoginVO userlogin(UserDTO userDTO) {
        User user1 = userMapper.select(userDTO);

        if(user1 != null){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id", user1.getId());
            String jwt = JwtUtils.generateJwt(claims);
            return new UserLoginVO(user1.getId(), user1.getUsername(),jwt);
        }else {
            return null;
        }
    }
}
