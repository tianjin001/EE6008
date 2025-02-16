package com.onlineLibrary.service.impl;

import com.onlineLibrary.DTO.ContactDTO;
import com.onlineLibrary.DTO.RequestFormDTO;
import com.onlineLibrary.context.BaseContext;
import com.onlineLibrary.entity.ContactForm;
import com.onlineLibrary.entity.RequestForm;
import com.onlineLibrary.mapper.HelpPageMapper;
import com.onlineLibrary.mapper.HomePageMapper;
import com.onlineLibrary.service.HelpPageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HelpPageServiceImpl implements HelpPageService {


    @Autowired
    private HelpPageMapper helpPageMapper;
    @Override
    public void saveRequestForm(RequestFormDTO requestFormDTO) {
        //
        RequestForm reqForm = new RequestForm();
        BeanUtils.copyProperties(requestFormDTO, reqForm);
        reqForm.setStatus(RequestForm.pending);
        //
        helpPageMapper.addRequestForm(reqForm);
    }

    /**
     * 新增建议
     * @param contactDTO
     */
    @Override
    public void saveContactForm(ContactDTO contactDTO) {

        ContactForm contactForm = new ContactForm();
        BeanUtils.copyProperties(contactDTO, contactForm);

        contactForm.setCreateTime(LocalDateTime.now());
        contactForm.setCreateUser(BaseContext.getCurrentId());

        helpPageMapper.addContactForm(contactForm);
    }
}
