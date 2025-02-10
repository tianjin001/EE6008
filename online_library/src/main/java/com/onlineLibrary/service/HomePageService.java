package com.onlineLibrary.service;

import com.onlineLibrary.DTO.TestbooksPageQueryDTO;
import com.onlineLibrary.entity.Books;
import com.onlineLibrary.result.PageResult;

import java.util.List;

public interface HomePageService {
    /**
     * 主页面书籍展示
     * @param testbooksPageQueryDTO
     * @return
     */
    PageResult pageQuery(TestbooksPageQueryDTO testbooksPageQueryDTO);

    /**
     * 查询评分最高书籍
     * @return
     */
    List<Books> topbooksQuery();

    /**
     * 查询新书籍
     * @return
     */
    List<Books> newbooksQuery();
}
