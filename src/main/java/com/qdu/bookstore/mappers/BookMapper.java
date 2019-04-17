package com.qdu.bookstore.mappers;

import com.qdu.bookstore.book.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @Author ShaneLau
 * Created by Shane Lau on 2019/4/12.
 */
@Mapper
public interface BookMapper {
    Book getBookById(@Param(value = "id") String id);

    ArrayList<Book> getAllBooks(@Param(value = "type") String type);
}
