package com.onlineLibrary.controller.admin;

import com.onlineLibrary.DTO.StaffDTO;
import com.onlineLibrary.VO.StaffLoginVO;
import com.onlineLibrary.result.Result;
import com.onlineLibrary.entity.Staff;
import com.onlineLibrary.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 管理员登录
     * @param staffDTO
     * @return
     */
    @PostMapping("/login")
    public Result<StaffLoginVO> login01(@RequestBody StaffDTO staffDTO) {

        String password = staffDTO.getPassword();
        staffDTO.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));

        StaffLoginVO staffLoginVO =  adminService.login01(staffDTO);

        if (staffLoginVO != null) {
           return Result.success(staffLoginVO);
        }else{
           return Result.error("wrong username or password");
        }
    }

    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }

    /**
     * 普通用户注册
     * @param staff
     * @return
     */
    @PostMapping("/register01")
    public Result register01(@RequestBody Staff staff) {
        Staff staff1 = adminService.selectByUsername(staff);
        if (staff1 != null) {
            System.out.println("username:"+ staff1.getUsername()+"is existed");
            return Result.error("username is existed");
        }else{
            adminService.register01(staff);
            return Result.success(staff);
        }
    }
}

