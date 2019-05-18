package com.qdu.bookstore.book.service;

import com.github.pagehelper.PageInfo;
import com.qdu.bookstore.book.pojo.Book;
import com.qdu.bookstore.vo.ResultVO;

import java.util.ArrayList;

public interface BookService{
    ResultVO getBookById(String id);

    ArrayList<Book> getAllBooks(String type, String genre);

    PageInfo<Book> search(String key, String type, int pagenum, int pagesize,String genre);

    ResultVO addBook(Book book);

    ResultVO deleteById(int id);

    ResultVO modifyBook(Book book);
}
