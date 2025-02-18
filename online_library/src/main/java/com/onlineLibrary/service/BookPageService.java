package com.onlineLibrary.service;

import com.onlineLibrary.DTO.BooksPageQueryDTO;
import com.onlineLibrary.DTO.CommentsDTO;
import com.onlineLibrary.result.PageResult;

public interface BookPageService {

    /**
     * 插入评论及分数 更新
     * @param commentsDTO
     */
    void insertComments(CommentsDTO commentsDTO);


    /**
     * 计算均分
     * @param bookId
     * @return
     */
    Double getAverageRating(Integer bookId);

    /**
     * 更新均分到book表
     * @param bookId
     * @param averageRating
     */
    void updateRating(Integer bookId, Double averageRating);

    /**
     * 查询书籍
     * @param booksPageQueryDTO
     * @return
     */
    PageResult pageQuery(BooksPageQueryDTO booksPageQueryDTO);
}
