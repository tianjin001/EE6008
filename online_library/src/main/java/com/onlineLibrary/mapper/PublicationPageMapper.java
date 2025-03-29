package com.onlineLibrary.mapper;

import com.github.pagehelper.Page;
import com.onlineLibrary.DTO.PublicationDTO;
import com.onlineLibrary.Entity.Publication;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PublicationPageMapper {
;
    /**
     * 查询书籍
     * @param publicationDTO
     * @return
     */
    Page<Publication> select(PublicationDTO publicationDTO);

}
