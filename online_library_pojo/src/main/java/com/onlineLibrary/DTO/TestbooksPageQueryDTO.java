package com.onlineLibrary.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestbooksPageQueryDTO implements Serializable {


    private String name;
    private String author;
    //页码
    private int page;

    //每页显示记录数
    private int pageSize;

}
