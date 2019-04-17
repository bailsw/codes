package com.qdu.bookstore.book.controller;/**
*                                                                      : ,       
*                                  +7?==?O$~                           :7?,, :~=,
*                                +Z~       +Z~,                        :I+IIO+++ 
*                              ,7=,          7:,                       :?:~Z8=   
*                              :I,            7,                       +?~IZ,    
*                             ,I:   ?     ?    ?                  ,~+Z+ :~+      
*                              $,              I,             ,:~77~, ,I7=       
*                             :Z                ?:   :~~+?Z$7I+: ,,,~7+          
*                              $,                7Z7I+::         :?$+,            
*                             ,?+                           ,+7I=                 
*                              ,7:                   ,:,=N?~,                    
*                             :7$,                   IZI$?                       
*                           ?$+: ,                    ++                         
*                         ~$ ,                        ,:I~                       
*    ,                   7=                              :I$~                    
*   ,O+               =I7$7, , ,     ,                      ,77:,                
*   ,I7,            =$?, ,,O~  ~+O$#4=                        :=7~               
*~II$:+$= ,,,:++?I7?,     :I:OZ+, :~7I,,,                    ,:??7+ ,            
*+D77$$?+I?~,,,      ,,:+O$ ,        :+I=:,,               =8I~ ,,,Z+            
*     =Z7=+++++==+7TMO~                  ~$+,            :?=,,,,,,,,:?,          
*                                           :O?,      :, ?:, ,,,,,,,,,$:         
*                                             ,+I:,    ,?+,, ,,,,,,,,,,7=        
*                                                :I77~ :Z, ,,,,,,,,,,,,,,?=       
*                                                  ,,I= I,,,,,,,,,,,,,,,,,?+      
*                                                     :~,                 :=     
*                     哪错了？             错哪了？              我是谁？
*/

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qdu.bookstore.book.pojo.Book;
import com.qdu.bookstore.book.service.BookService;
import com.qdu.bookstore.vo.ResultVO;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/** @Author ShaneLau
 * Created by Shane Lau on 2019/4/12.
 */
@RestController
@RequestMapping("/book")
public class BookController {
    private final int DEFAULT_PAGE_SIZE=20;
    @Autowired
    private BookService bookService;

    @RequestMapping("getbookbyid")
    public ResultVO getBookById(String id){
        return bookService.getBookById(id);
    }

    @RequestMapping("getbookbytypeandpage")
    public PageInfo<Book> getBookByPage(@RequestParam(value = "pagenum",defaultValue = "1",required = false) int pagenum,
                                   @RequestParam(value = "type",required = false)String type ){
       PageHelper.startPage(pagenum,DEFAULT_PAGE_SIZE);
       ArrayList<Book>books=bookService.getAllBooks(type);
       return new PageInfo<Book>(books);
    }


}
