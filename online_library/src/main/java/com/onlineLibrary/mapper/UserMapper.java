package com.onlineLibrary.mapper;

import com.onlineLibrary.DTO.StaffDTO;
import com.onlineLibrary.DTO.UserDTO;
import com.onlineLibrary.entity.Staff;
import com.onlineLibrary.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User select(UserDTO userDTO);
    //(@Param("username") String  username,@Param("password") String password)

}
