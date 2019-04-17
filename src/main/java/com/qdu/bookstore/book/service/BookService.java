package com.qdu.bookstore.book.service;

import com.github.pagehelper.PageInfo;
import com.qdu.bookstore.book.pojo.Book;
import com.qdu.bookstore.vo.ResultVO;

import java.util.ArrayList;

/**
 * @Author ShaneLau
 * Created by Shane Lau on 2019/4/17.
 */
public interface BookService{
    ResultVO getBookById(String id);

    ArrayList<Book> getAllBooks(String type);

    PageInfo<Book> search(String key, String type, int pagenum);
}
