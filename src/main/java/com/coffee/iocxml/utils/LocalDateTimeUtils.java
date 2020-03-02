package com.coffee.iocxml.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtils {

    public static String formatNow() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(DateTimeFormatter.ofPattern(pattern));
        return format;
    }

    public static LocalDateTime string2parse(String time, String pattern) {
        LocalDateTime result = LocalDateTime.parse(time, DateTimeFormatter.ofPattern(pattern));
        return result;
    }

    /**
     * 自己指定格式
     * @param pattern
     * @return
     */
    public static String formatOther(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));

    }
}
