package com.qdu.bookstore.mappers;

import com.qdu.bookstore.booktype.pojo.BookType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author ShaneLau
 * Created by Shane Lau on 2019/4/26.
 */
@Mapper
public interface BookTypeMapper {
    void updateBookType(BookType bookType);

    void deleteBookType(@Param(value = "booktype_id") int booktype_id);

    List<BookType> getAllBookType();

    void addBookType(BookType bookType);
}
