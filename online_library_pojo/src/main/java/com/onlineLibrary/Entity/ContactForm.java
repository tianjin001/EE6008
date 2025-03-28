package com.onlineLibrary.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactForm {

    private String email;
    private String subject;
    private String message;

    private LocalDateTime createTime;
    private Integer createUser;

}
