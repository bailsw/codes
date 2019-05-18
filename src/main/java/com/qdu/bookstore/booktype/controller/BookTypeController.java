package com.qdu.bookstore.booktype.controller;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bookstore.booktype.pojo.BookType;
import com.qdu.bookstore.booktype.service.BookTypeService;
import com.qdu.bookstore.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/booktype")
public class BookTypeController {
    @Autowired
    private BookTypeService bookTypeService;

    @RequestMapping("addbooktype")
    public ResultVO addBookType(BookType bookType){
        return bookTypeService.addBookType(bookType);
    }
    @RequestMapping("updatebooktype")
    public ResultVO updateBookType(BookType bookType){
        return bookTypeService.updateBookType(bookType);
    }
    @RequestMapping("deletebooktype")
    public ResultVO deleteBookType(int booktype_id){
        return bookTypeService.deleteBookType(booktype_id);
    }
    @RequestMapping("getallbooktype")
    public PageInfo<BookType> getAllBookType(@RequestParam(value = "pagenum" ,defaultValue = "1") int pagenum,
                                             @RequestParam(value = "pagesize" ,defaultValue = "10")int pagesize){
        PageHelper.startPage(pagenum,pagesize);
        return new PageInfo<BookType>(bookTypeService.getAllBookType()) ;

    }
}
