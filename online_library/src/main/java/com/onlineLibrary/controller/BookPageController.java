package com.onlineLibrary.controller;


import com.onlineLibrary.DTO.CommentsDTO;
import com.onlineLibrary.result.Result;
import com.onlineLibrary.service.BookPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookPageController {

    @Autowired
    private BookPageService bookPageService;
    /**
     * 插入评论及打分 并更新
     * @param commentsDTO
     * @return
     */
    @PostMapping
    public Result insertComments(@RequestBody CommentsDTO commentsDTO){
        //插入评论
        bookPageService.insertComments(commentsDTO);
        // 获取最新的书籍评分平均值 返回给前端
        Double averageRating = bookPageService.getAverageRating(commentsDTO.getBookId());
        //更新rating到book表
        bookPageService.updateRating(commentsDTO.getBookId(),averageRating);
        return Result.success(averageRating);
    }
}
