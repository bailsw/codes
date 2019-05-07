package com.qdu.bookstore.book.service.impl;/**
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
import com.qdu.bookstore.mappers.BookMapper;
import com.qdu.bookstore.book.pojo.Book;
import com.qdu.bookstore.book.service.BookService;
import com.qdu.bookstore.utils.ResultVOUtil;
import com.qdu.bookstore.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/** @Author ShaneLau
 * Created by Shane Lau on 2019/4/17.
 */
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
    public PageInfo<Book> search(String key, String type, int pagenum, String genre) {
        PageHelper.startPage(20,pagenum);
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
