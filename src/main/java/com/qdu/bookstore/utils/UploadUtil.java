package com.qdu.bookstore.utils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;


public class UploadUtil {
    private static String TMPDIR = "D:\\2019Biyesheji\\codes\\src\\main\\resources\\static\\";
    public static String uploadFile(MultipartFile file) {
        String fileName = null;
        try {
            if (file.isEmpty()) {
                return null;
            }
            UUID uuid = UUID.randomUUID();
            fileName = uuid.toString() + new Random().nextInt(10000)+
                    file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'),file.getOriginalFilename().length());
            String path = TMPDIR + fileName;
            File dest = new File(path);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);
            return fileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
