package com.onlineLibrary.service;

import com.onlineLibrary.DTO.StaffDTO;
import com.onlineLibrary.VO.StaffLoginVO;
import com.onlineLibrary.entity.Staff;

public interface AdminService {
     StaffLoginVO login01(StaffDTO staffDTO);

     Staff selectByUsername(Staff staff);

     void register01(Staff staff);


}


