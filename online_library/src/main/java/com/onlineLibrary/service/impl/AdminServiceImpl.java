package com.onlineLibrary.service.impl;

import com.onlineLibrary.DTO.StaffDTO;
import com.onlineLibrary.mapper.StaffMapper;
import com.onlineLibrary.VO.StaffLoginVO;
import com.onlineLibrary.entity.Staff;
import com.onlineLibrary.service.AdminService;
import com.onlineLibrary.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private StaffMapper staffMapper;

    @Override
    public StaffLoginVO login01(StaffDTO staffDTO){

         Staff staff1 = staffMapper.select(staffDTO);

         if(staff1 != null){
             Map<String,Object> claims = new HashMap<>();
             claims.put("id", staff1.getId());
             String jwt = JwtUtils.generateJwt(claims);
             return new StaffLoginVO(staff1.getId(), staff1.getUsername(), staff1.getName(),jwt);
         }else {
             return null;
         }
    }
    //user.getUsername(), user.getPassword()

    @Override
    public Staff selectByUsername(Staff staff) {
        return staffMapper.selectByCondition(staff.getUsername());
    }

    @Override
    public void register01(Staff staff) {
        staffMapper.add(staff);
    }


}
