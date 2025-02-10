package com.onlineLibrary.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.onlineLibrary.DTO.TestbooksPageQueryDTO;
import com.onlineLibrary.entity.Books;
import com.onlineLibrary.entity.Testbooks;
import com.onlineLibrary.mapper.HomePageMapper;
import com.onlineLibrary.result.PageResult;
import com.onlineLibrary.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HomePageServiceImpl implements HomePageService {

    @Autowired
    private HomePageMapper homePageMapper;

    /**
     * 主页面书籍展示
     * @param testbooksPageQueryDTO
     * @return
     */
    @Override
    public PageResult pageQuery(TestbooksPageQueryDTO testbooksPageQueryDTO) {
        //设置分页参数
        PageHelper.startPage(testbooksPageQueryDTO.getPage(), testbooksPageQueryDTO.getPageSize());

        //调用Mapper查数据
        Page<Testbooks> page = homePageMapper.select01(testbooksPageQueryDTO);

        //数据封装
        long total = page.getTotal();
        List<Testbooks> records = page.getResult();
        //返回
        return new PageResult(total, records);
    }

    /**
     * 查询评分最高书籍
     * @return
     */
    @Override
    public List<Books> topbooksQuery() {
        List<Books> books = homePageMapper.seletTopBooks();
        return books;
    }

    /**
     * 查询新书籍
     * @return
     */
    @Override
    public List<Books> newbooksQuery() {
        List<Books> books = homePageMapper.seletNewBooks();
        return books;
    }
}

