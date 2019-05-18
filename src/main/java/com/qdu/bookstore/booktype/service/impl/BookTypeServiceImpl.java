package com.qdu.bookstore.booktype.service.impl;


import com.github.pagehelper.PageInfo;
import com.qdu.bookstore.booktype.pojo.BookType;
import com.qdu.bookstore.booktype.service.BookTypeService;
import com.qdu.bookstore.mappers.BookTypeMapper;
import com.qdu.bookstore.utils.ResultVOUtil;
import com.qdu.bookstore.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookTypeServiceImpl implements BookTypeService {
    @Autowired
    private BookTypeMapper bookTypeMapper;
    @Override
    public ResultVO updateBookType(BookType bookType) {
        try{
            bookTypeMapper.updateBookType(bookType);
            return ResultVOUtil.success(null);
        }catch (Exception e){
            return ResultVOUtil.error("");
        }
    }

    @Override
    public ResultVO deleteBookType(int booktype_id) {
        try{
            bookTypeMapper.deleteBookType(booktype_id);
            return ResultVOUtil.success("");
        }catch (Exception e){
            return ResultVOUtil.error("");
        }
    }

    @Override
    public List<BookType> getAllBookType() {
       return bookTypeMapper.getAllBookType();
    }

    @Override
    public ResultVO addBookType(BookType bookType) {
        try{
            bookTypeMapper.addBookType(bookType);
            return ResultVOUtil.success("");
        }catch (Exception e){
            return ResultVOUtil.error("");
        }
    }
}
