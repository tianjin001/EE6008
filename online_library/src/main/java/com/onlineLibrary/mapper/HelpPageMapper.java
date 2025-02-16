package com.onlineLibrary.mapper;

import com.onlineLibrary.annotation.AutoFill;
import com.onlineLibrary.entity.ContactForm;
import com.onlineLibrary.entity.RequestForm;
import com.onlineLibrary.enumeration.OperationType;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HelpPageMapper {

    /**
     * 新增购书请求
     * @param reqForm
     */
    @AutoFill(value = OperationType.INSERT)
    @Insert("INSERT INTO request_form (title, author, isbn, publisher, publishYear, reason,status,create_time,create_user,update_time,update_user) " +
            "VALUES (#{title}, #{author}, #{isbn}, #{publisher}, #{publishYear}, #{reason},#{status},#{createTime},#{createUser},#{updateTime},#{updateUser})")
    void addRequestForm(RequestForm reqForm);

    /**
     * 新增建议
     * @param contactForm
     */
    @Insert("INSERT INTO contact_form ( email,subject,message,create_time,create_user) " +
            "VALUES (#{email}, #{subject}, #{message},#{createTime},#{createUser})")
    void addContactForm(ContactForm contactForm);
}
