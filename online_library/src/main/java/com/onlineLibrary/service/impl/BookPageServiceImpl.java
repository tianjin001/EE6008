package com.onlineLibrary.service.impl;

import com.onlineLibrary.DTO.CommentsDTO;
import com.onlineLibrary.entity.Comments;
import com.onlineLibrary.mapper.BookPageMapper;
import com.onlineLibrary.service.BookPageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookPageServiceImpl implements BookPageService {

    //插入评论 打分
    //计算均值
    //更新book表
    @Autowired
    private BookPageMapper bookPageMapper;
    /**
     * 插入评论  均值  更新
     * @param commentsDTO
     */
    @Transactional
    @Override
    public void insertComments(CommentsDTO commentsDTO) {

        Comments comments = new Comments();
        BeanUtils.copyProperties(commentsDTO, comments);

        bookPageMapper.insertComment(comments);
        // 计算书籍的平均评分
        Double averageRating = bookPageMapper.getAverageRating(comments.getBookId());
        //更新到book表中
        bookPageMapper.updateBookRating(comments.getBookId(), averageRating);
    }


    /**
     * 计算均值
     * @param bookId
     * @return
     */
    @Override
    public Double getAverageRating(Integer bookId) {
        return bookPageMapper.getAverageRating(bookId);
    }

    /**
     * 更新rating
     * @param bookId
     * @param averageRating
     */
    @Override
    public void updateRating(Integer bookId, Double averageRating) {
        bookPageMapper.updateBookRating(bookId,averageRating);
    }
}
