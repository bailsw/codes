package com.qdu.bookstore.utils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
@RequestMapping("/img")
public class ImageController {
    @RequestMapping("/{img}")
    public void resolveImg(@PathVariable(value="img")String img, HttpServletResponse response){
        response.setContentType("image/jpeg");
        File file=new File("D:\\2019Biyesheji\\codes\\src\\main\\resources\\static\\"+img);
        if (file.exists()){
            FileInputStream fos=null;
            try {
                byte[] filebytes=new byte[(int)(file.length())];
                fos=new FileInputStream(file);
                fos.read(filebytes);
                response.getOutputStream().write(filebytes);
                response.getOutputStream().flush();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    if (fos!=null){
                        fos.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
