package com.onlineLibrary.service;

import com.onlineLibrary.DTO.BooksPageQueryDTO;
import com.onlineLibrary.DTO.PublicationDTO;
import com.onlineLibrary.result.PageResult;

public interface PublicationPageService {
    //TODO
    /**
     * 查询书籍
     * @param publicationDTO
     * @return
     */
    PageResult pageQuery(PublicationDTO publicationDTO);

}
