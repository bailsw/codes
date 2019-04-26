package com.qdu.bookstore.booktype.service;

import com.github.pagehelper.PageInfo;
import com.qdu.bookstore.booktype.pojo.BookType;
import com.qdu.bookstore.vo.ResultVO;

import java.util.List;

/**
 * @Author ShaneLau
 * Created by Shane Lau on 2019/4/26.
 */
public interface BookTypeService {
    ResultVO addBookType(BookType bookType);

    ResultVO updateBookType(BookType bookType);

    ResultVO deleteBookType(int booktype_id);

    List<BookType> getAllBookType();
}
