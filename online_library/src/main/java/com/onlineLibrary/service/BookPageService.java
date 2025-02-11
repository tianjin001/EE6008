package com.onlineLibrary.service;

import com.onlineLibrary.DTO.CommentsDTO;

public interface BookPageService {

    /**
     * 插入评论及分数
     * @param commentsDTO
     */
    void insertComments(CommentsDTO commentsDTO);
}
