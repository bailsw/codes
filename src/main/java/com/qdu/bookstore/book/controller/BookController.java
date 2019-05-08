package com.qdu.bookstore.book.controller;/**
 * : ,
 * +7?==?O$~                           :7?,, :~=,
 * +Z~       +Z~,                        :I+IIO+++
 * ,7=,          7:,                       :?:~Z8=
 * :I,            7,                       +?~IZ,
 * ,I:   ?     ?    ?                  ,~+Z+ :~+
 * $,              I,             ,:~77~, ,I7=
 * :Z                ?:   :~~+?Z$7I+: ,,,~7+
 * $,                7Z7I+::         :?$+,
 * ,?+                           ,+7I=
 * ,7:                   ,:,=N?~,
 * :7$,                   IZI$?
 * ?$+: ,                    ++
 * ~$ ,                        ,:I~
 * ,                   7=                              :I$~
 * ,O+               =I7$7, , ,     ,                      ,77:,
 * ,I7,            =$?, ,,O~  ~+O$#4=                        :=7~
 * ~II$:+$= ,,,:++?I7?,     :I:OZ+, :~7I,,,                    ,:??7+ ,
 * +D77$$?+I?~,,,      ,,:+O$ ,        :+I=:,,               =8I~ ,,,Z+
 * =Z7=+++++==+7TMO~                  ~$+,            :?=,,,,,,,,:?,
 * :O?,      :, ?:, ,,,,,,,,,$:
 * ,+I:,    ,?+,, ,,,,,,,,,,7=
 * :I77~ :Z, ,,,,,,,,,,,,,,?=
 * ,,I= I,,,,,,,,,,,,,,,,,?+
 * :~,                 :=
 * 哪错了？             错哪了？              我是谁？
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bookstore.book.pojo.Book;
import com.qdu.bookstore.book.service.BookService;
import com.qdu.bookstore.utils.ResultVOUtil;
import com.qdu.bookstore.utils.StringUtil;
import com.qdu.bookstore.utils.UploadUtil;
import com.qdu.bookstore.vo.ResultVO;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.session.web.http.DefaultCookieSerializer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URLDecoder;
import java.util.ArrayList;

/**
 * @Author ShaneLau
 * Created by Shane Lau on 2019/4/12.
 */
@RestController
@RequestMapping("/book")
@CrossOrigin
public class BookController {
    private final int DEFAULT_PAGE_SIZE = 20;
    @Autowired
    private BookService bookService;

    @RequestMapping("getbookbyid")
    public ResultVO getBookById(String id) {
        return bookService.getBookById(id);
    }

    @RequestMapping("getbookbytypeandpage")
    public PageInfo<Book> getBookByPage(@RequestParam(value = "pagenum", defaultValue = "1", required = false) int pagenum,
                                        @RequestParam(value = "type", required = false,defaultValue = "") String type,
                                        @RequestParam(value = "genre",required = false,defaultValue = "")String genre) {
        //System.out.println(111);
        PageHelper.startPage(pagenum, DEFAULT_PAGE_SIZE);
        System.out.println(genre);
        ArrayList<Book> books = bookService.getAllBooks(type,genre);
        return new PageInfo<Book>(books);
    }

    @RequestMapping("searchbookbykeytypepage")
    public PageInfo<Book> searchBookByKeyTypePage(
            @RequestParam(value = "key", defaultValue = "") String key,
            @RequestParam(value = "type", defaultValue = "") String type,
            @RequestParam(value = "pagenum", defaultValue = "1") int pagenum,
            @RequestParam(value = "genre",required = false,defaultValue = "")String genre) {
        //System.out.println(111);
        return bookService.search(key, type, pagenum,genre);

    }

    @RequestMapping("addbook")
    public ResultVO addBook(@RequestParam(value = "book_name")String book_name,
                            @RequestParam(value = "book_genre")int book_genre,
                            @RequestParam(value = "book_typeid")int book_typeid,
                            @RequestParam(value = "book_price")String book_price,
                            @RequestParam(value = "book_pic") MultipartFile book_pic,
                            @RequestParam(value = "book_info")String book_info,
                            @RequestParam(value = "book_ISBN") String book_ISBN,
                            @RequestParam(value = "book_author")String book_author,
                            @RequestParam(value = "book_publishingHouse")String book_publishingHouse,
                            @RequestParam(value = "book_stock")int book_stock){
        String pic=null;
        try{
           pic = UploadUtil.uploadFile(book_pic);
        }catch (Exception e){
            return ResultVOUtil.error("fail");
        }

        if (StringUtil.isEmpty(pic)){
            return ResultVOUtil.error("fail");
        }
        Book book=new Book();
        book.setBook_author(book_author);
        book.setBook_info(book_info);
        book.setBook_ISBN(book_ISBN);
        book.setBook_pic(pic);
        book.setBook_price(Integer.valueOf(book_price));
        book.setBook_stock(book_stock);
        book.setBook_publishingHouse(book_publishingHouse);
        book.setBook_typeid(book_typeid);
        book.setBook_genre(book_genre);
        book.setBook_name(book_name);
       return bookService.addBook(book);
    }

    @RequestMapping("deletebookbyid")
    public ResultVO deleteBookById(@RequestParam(value = "id") int id){
       return bookService.deleteById(id);
    }

    @RequestMapping("modifybook")
    public ResultVO modifyBook(@RequestParam(value = "book_name")String book_name,
                               @RequestParam(value = "book_id")String book_id,
                            @RequestParam(value = "book_genre")String book_genre,
                            @RequestParam(value = "book_typeid")String book_typeid,
                            @RequestParam(value = "book_price")String book_price,
                            @RequestParam(value = "book_info")String book_info,
                            @RequestParam(value = "book_ISBN") String book_ISBN,
                            @RequestParam(value = "book_author")String book_author,
                            @RequestParam(value = "book_publishingHouse")String book_publishingHouse,
                            @RequestParam(value = "book_stock")String book_stock){
        Book book=new Book();
        book.setBook_id(Integer.valueOf(book_id));
        book.setBook_author(book_author);
        book.setBook_info(book_info);
        book.setBook_ISBN(book_ISBN);
        book.setBook_price(Integer.valueOf(book_price));
        book.setBook_stock(Integer.valueOf(book_stock));
        book.setBook_publishingHouse(book_publishingHouse);
        book.setBook_typeid(Integer.valueOf(book_typeid));
        book.setBook_genre(Integer.valueOf(book_genre));
        book.setBook_name(book_name);
        return bookService.modifyBook(book);
    }
}
