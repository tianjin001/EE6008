package com.onlineLibrary.mapper;

import com.github.pagehelper.Page;
import com.onlineLibrary.DTO.TestbooksPageQueryDTO;
import com.onlineLibrary.entity.Books;
import com.onlineLibrary.entity.Testbooks;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HomePageMapper {
     Page<Testbooks> select01(TestbooksPageQueryDTO testbooksPageQueryDTO);

     @Select("SELECT * FROM book ORDER BY rating DESC LIMIT 5;")
     List<Books> seletTopBooks();

     @Select("SELECT * FROM book ORDER BY publishDate DESC LIMIT 5;")
     List<Books> seletNewBooks();
}
