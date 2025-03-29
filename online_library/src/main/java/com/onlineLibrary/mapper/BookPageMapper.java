package com.onlineLibrary.mapper;

import com.github.pagehelper.Page;
import com.onlineLibrary.DTO.BooksPageQueryDTO;
import com.onlineLibrary.VO.BooksVO;
import com.onlineLibrary.annotation.AutoFill;
import com.onlineLibrary.Entity.Comments;
import com.onlineLibrary.enumeration.OperationType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookPageMapper {
    /**
     * 插入评论及分数
     */
    @AutoFill(value = OperationType.INSERT)
    void insertComment(Comments comments);

    /**
     * 计算书籍均分
     * @param bookId
     * @return
     */
    Double getAverageRating(Integer bookId);

    /**
     * 更新book rating
     * @param bookId
     * @param averageRating
     */
    void updateBookRating(Integer bookId, Double averageRating);

    /**
     * 查询书籍
     * @param booksPageQueryDTO
     * @return
     */
    Page<BooksVO> select01(BooksPageQueryDTO booksPageQueryDTO);

    Page<BooksVO> select02(BooksPageQueryDTO booksPageQueryDTO);
}
