package com.onlineLibrary.service;

import com.onlineLibrary.DTO.ContactDTO;
import com.onlineLibrary.DTO.RequestFormDTO;

public interface HelpPageService {
    /**
     * 新增购书请求
     * @param requestFormDTO
     */
    void saveRequestForm(RequestFormDTO requestFormDTO);

    /**
     * 建议
     * @param contactDTO
     */
    void saveContactForm(ContactDTO contactDTO);
}
