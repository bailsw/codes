package com.qdu.bookstore.book.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bookstore.mappers.BookMapper;
import com.qdu.bookstore.book.pojo.Book;
import com.qdu.bookstore.book.service.BookService;
import com.qdu.bookstore.utils.ResultVOUtil;
import com.qdu.bookstore.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Override
    public ResultVO getBookById(String id) {
        Book book=bookMapper.getBookById(id);
        if (book!=null){
           // System.out.println(book.toString());
            return ResultVOUtil.success(book);
        }
        return ResultVOUtil.error("fail");
    }

    @Override
    public PageInfo<Book> search(String key, String type, int pagenum,int pagesize, String genre) {
        PageHelper.startPage(pagenum,pagesize);
            key= URLDecoder.decode(key);
        ArrayList books=bookMapper.search(key,type,genre);
        return new PageInfo<Book>(books);
    }

    @Override
    public ResultVO addBook(Book book) {
        try {
            bookMapper.addBook(book);
            return ResultVOUtil.success(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.error("fail");
        }
    }

    @Override
    public ArrayList<Book> getAllBooks(String type, String genre) {

        return bookMapper.getAllBooks(type,genre);
    }

    @Override
    public ResultVO deleteById(int id) {
        try{
            bookMapper.deleteById(id);
            return ResultVOUtil.success(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.error(null);
        }

    }

    @Override
    public ResultVO modifyBook(Book book) {
        try{
            bookMapper.modifyBook(book);
            return ResultVOUtil.success(null);
        }catch (Exception e){
            e.printStackTrace();
            return ResultVOUtil.error(null);
        }
    }
}
