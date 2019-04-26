package com.qdu.bookstore.booktype.controller;/**
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
import com.qdu.bookstore.booktype.pojo.BookType;
import com.qdu.bookstore.booktype.service.BookTypeService;
import com.qdu.bookstore.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** @Author ShaneLau
 * Created by Shane Lau on 2019/4/26.
 */
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
    public PageInfo<BookType> getAllBookType(int pagenum,int pagesize){
        if (pagenum==0)pagenum=1;
        if (pagesize==0)pagesize=5;
        PageHelper.startPage(1,5);
        return new PageInfo<BookType>(bookTypeService.getAllBookType()) ;

    }
}
