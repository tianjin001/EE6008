package com.onlineLibrary.mapper;

import com.onlineLibrary.DTO.LoginDTO;
import com.onlineLibrary.entity.User;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface LoginMapper {
    User select(LoginDTO loginDTO);
    //(@Param("username") String  username,@Param("password") String password)

    User selectByCondition(String username);

    void add(User user);

}
