package com.onlineLibrary.service.impl;

import com.onlineLibrary.DTO.CommentsDTO;
import com.onlineLibrary.entity.Comments;
import com.onlineLibrary.mapper.BookPageMapper;
import com.onlineLibrary.service.BookPageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookPageServiceImpl implements BookPageService {

    //插入评论 打分
    //计算均值
    //更新book表
    @Autowired
    private BookPageMapper bookPageMapper;
    /**
     * 插入评论及分数
     * @param commentsDTO
     */
    @Override
    public void insertComments(CommentsDTO commentsDTO) {
        Comments comments = new Comments();
        BeanUtils.copyProperties(commentsDTO, comments);

        bookPageMapper.insertComment(comments);
    }
}
