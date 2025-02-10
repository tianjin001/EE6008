package com.onlineLibrary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Testbooks {
    private Integer id;
    private String name;
    private String author;
    private String description;
    private String image;
}
