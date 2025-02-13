package com.onlineLibrary.VO;

import lombok.Data;

@Data

public class UserLoginVO {
    private Integer id;
    private String username;
    private String token;

    // 无参构造函数
    public UserLoginVO() {}

    // 带参构造函数
    public UserLoginVO(Integer id, String username, String token) {
        this.id = id;
        this.username = username;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
