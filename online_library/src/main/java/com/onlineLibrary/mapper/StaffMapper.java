package com.onlineLibrary.mapper;

import com.onlineLibrary.DTO.StaffDTO;
import com.onlineLibrary.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface StaffMapper {
    Staff select(StaffDTO staffDTO);
    //(@Param("username") String  username,@Param("password") String password)

    Staff selectByCondition(String username);

    void add(Staff staff);

}
