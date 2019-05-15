package com.qdu.bookstore.config;/**
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

import com.qdu.bookstore.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/** @Author ShaneLau
 * Created by Shane Lau on 2019/4/8.
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Autowired
    private UserInterceptor userInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor).addPathPatterns("/**").excludePathPatterns("/buyer/**","/book/**","/booktype/**","/img/**");
    }
}
