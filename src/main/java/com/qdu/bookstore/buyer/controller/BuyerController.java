package com.qdu.bookstore.buyer.controller;/**
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

import com.qdu.bookstore.buyer.pojo.Buyer;
import com.qdu.bookstore.buyer.service.BuyerService;
import com.qdu.bookstore.utils.MD5Util;
import com.qdu.bookstore.utils.ResultVOUtil;
import com.qdu.bookstore.utils.StringUtil;
import com.qdu.bookstore.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * Created by Shane Lau on 2019/3/13.
 */
@Controller
@RequestMapping("/buyer")
public class BuyerController {
    @Autowired
    BuyerService buyerService;

    //检查用户名唯一
    @RequestMapping("checkusername")
    @ResponseBody
    public String checkUsername(String buyer_username) {
        if (buyerService.checkUsername(buyer_username)){
            return "fail";
        };
        return "ok";
    }

    // 注册
    @RequestMapping("register")
    @ResponseBody
    public String register(Buyer buyer, String repassword) {
        //判断两次密码是否一致
        if (StringUtil.isEqualsIgnoreCase(buyer.getBuyer_Password(), repassword)) {
            // 代表一致
            try {
                buyer.setBuyer_Password(MD5Util.MD5Encode(buyer.getBuyer_Password(), "MD5"));//将原始目的密码转换成md5校验值,然后重新设置给对象
                buyerService.addUser(buyer);
                return "success";
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return "fail";
    }

    //登陆
    @RequestMapping("login")
    @ResponseBody
    public ResultVO login(Buyer buyer, HttpServletRequest request, HttpServletResponse response){
        Buyer buyer1 = buyerService.login(buyer);
        if (buyer1!=null){
            if (buyer1 != null) {
                String string = UUID.randomUUID().toString();
                request.getSession().setAttribute("buyer", buyer1);
                request.getSession().setAttribute("token", string);
                Cookie cookie = new Cookie("token", string);
                cookie.setPath("/");
                cookie.setHttpOnly(false);
                response.addCookie(cookie);
                return ResultVOUtil.success(buyer1);
            }
        };
        return ResultVOUtil.error(1,"登录失败");
    }
    @RequestMapping("forget1")
    @ResponseBody
    public String forget1(String buyer_username,HttpServletRequest request){

        Buyer buyer=buyerService.getUserByUsername(buyer_username);
        if (buyer!=null){
            request.getSession().setAttribute("forgetpassworduser",buyer);
            return buyer.getBuyer_Passwordquestion();
        }
        return "usernotexists";
    }
    @RequestMapping("forget2")
    @ResponseBody
    public String forget2(String buyer_passwordAnswer, HttpServletRequest request){
        Buyer forgetpassworduser = (Buyer) request.getSession().getAttribute("forgetpassworduser");
        if (buyer_passwordAnswer.equals(forgetpassworduser.getBuyer_Passwordanswer())){
            return "success";
        }
        return "fail";
    }
    @RequestMapping("forget3")
    @ResponseBody
    public String forget3(String password,String repassword,HttpServletRequest request){
        Buyer forgetpassworduser = (Buyer) request.getSession().getAttribute("forgetpassworduser");
        if (password.equals(repassword))
        {
           int i= buyerService.changeBuyerPassword(password,forgetpassworduser);
           if (i!=0){
               request.getSession().removeAttribute("forgetpassworduser");
               return "success";
           }
        }
        return "fail";
    }

    @RequestMapping("changepassword")
    @ResponseBody
    public String changeaPassword(String password,String repassword,HttpServletRequest request){
        Buyer buyer= (Buyer)request.getSession().getAttribute("loggeduser");
        if (password!=null&&(password.equals(repassword))&&buyer!=null){
            buyerService.changeBuyerPassword(password,buyer);
            return "success";
        }
        return "fail";
    }
}
