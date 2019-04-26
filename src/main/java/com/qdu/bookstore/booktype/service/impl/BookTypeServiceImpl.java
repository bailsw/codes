package com.qdu.bookstore.booktype.service.impl;/**
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

import com.github.pagehelper.PageInfo;
import com.qdu.bookstore.booktype.pojo.BookType;
import com.qdu.bookstore.booktype.service.BookTypeService;
import com.qdu.bookstore.mappers.BookTypeMapper;
import com.qdu.bookstore.utils.ResultVOUtil;
import com.qdu.bookstore.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/** @Author ShaneLau
 * Created by Shane Lau on 2019/4/26.
 */
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
