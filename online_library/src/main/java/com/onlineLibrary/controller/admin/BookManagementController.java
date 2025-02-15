package com.onlineLibrary.controller.admin;


import com.onlineLibrary.DTO.BooksPageQueryDTO;
import com.onlineLibrary.result.PageResult;
import com.onlineLibrary.result.Result;
import com.onlineLibrary.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/book")
public class BookManagementController {

    @Autowired
    private HomePageService homePageService;

    /**
     * 条件查询书籍并分页展示
     * @param booksPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    public Result<PageResult> pageQuery(BooksPageQueryDTO booksPageQueryDTO){
        PageResult pageResult = homePageService.pageQuery(booksPageQueryDTO);
        return Result.success(pageResult);
    }




}
