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

    //TODO 创建review表
    // 写评论 评分插入到review表-book表分数改变
    // service：1.插入 reviewMapper 2.均值 reviewMapper 3.book更新数据 bookMapper
    // 传递给homepage的数据改变

    /**
     * 插入评论及打分
     * @param commentsDTO
     * @return
     */
    @PostMapping
    public Result insertComments(@RequestBody CommentsDTO commentsDTO){
        bookPageService.insertComments(commentsDTO);
        return Result.success();
    }
}
