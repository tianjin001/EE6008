package com.onlineLibrary.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BooksDTO {

    private String title; // 书名
    private String author; // 作者
    private String publisher; // 出版社
    private String isbn; // ISBN
    private LocalDateTime publishDate; // 出版日期
    private String category; // 分类
}
