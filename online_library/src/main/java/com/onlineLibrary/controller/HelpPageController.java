package com.onlineLibrary.controller;


import com.onlineLibrary.DTO.ContactDTO;
import com.onlineLibrary.DTO.RequestFormDTO;
import com.onlineLibrary.result.Result;
import com.onlineLibrary.service.HelpPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/help")
public class HelpPageController {

    @Autowired
    private HelpPageService helpPageService;

    /**
     * 新增购书请求
     * @param requestFormDTO
     * @return
     */
    @PostMapping("/request")
    public Result saveRequestForm(@RequestBody RequestFormDTO requestFormDTO) {
        helpPageService.saveRequestForm(requestFormDTO);
        return Result.success();
    }

    @PostMapping("/contact")
    public Result saveContactForm(@RequestBody ContactDTO contactDTO) {
        helpPageService.saveContactForm(contactDTO);
        return Result.success();
    }



}
