package com.onlineLibrary.mapper;

import com.onlineLibrary.entity.User;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserMapper {
    User select(User user);
    //(@Param("username") String  username,@Param("password") String password)

    User selectByCondition(String username);

    void add(User user);

}
