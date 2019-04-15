package com.qdu.bookstore.utils;



public class StringUtil {

    public static boolean isEmpty(String source) {
        return source == null || "".equalsIgnoreCase(source);
    }

    public static boolean isEqualsIgnoreCase(String s1, String s2) {

        return !isEmpty(s1) && s1.equalsIgnoreCase(s2);
    }
}
