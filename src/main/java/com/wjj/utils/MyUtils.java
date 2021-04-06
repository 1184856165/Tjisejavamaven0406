package com.wjj.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MyUtils {

    @Deprecated
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("本周是这一年的第几周？" + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("---------------------------------");
        Date date = new Date();
        System.out.println("当前系统时间:" + date.toString());
        // yyyy-MM-dd HH:mm:ss.S
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);

        System.out.println("当前系统时间:" + simpleDateFormat.format(date));
    }

    /**
     * 将Date类型转换为指定格式的日期类型的字符串
     *
     * @param date          被转化的Date类型
     * @param strDateFormat 需要转换的日期字符串的格式【默认：yyyy-MM-dd HH:mm:ss】
     * @return 日期变量的指定格式的字符串
     */
    public static String convertDate2String(Date date, String strDateFormat) {
        // 默认值
        String strDate = "";
        // 默认值根据业务逻辑确定，此处使用当前时间作为默认值；
        if (date == null) {
            date = new Date();
        }
        if (strDateFormat == null || strDateFormat.equals("")) {
            // 指定默认的格式串
            strDateFormat = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);
        // 转换为字符串
        strDate = simpleDateFormat.format(date);
        return strDate;
    }

    /**
     * 将指定格式的日期类型的字符串转换为Date类型
     *
     * @param strDate       日期字符串 【2021-04-06】
     * @param strDateFormat 日期字符串的格式【yyyy-MM-dd yyyy/MM/dd 需要保证：格式串和日期类型的字符串的格式是匹配的】
     * @return 日期类型
     */
    public static Date convertString2Date(String strDate, String strDateFormat) {
        // 默认值根据业务逻辑确定，此处使用当前时间作为默认值；
        Date date = new Date();
        if (strDateFormat == null || strDateFormat.equals("")) {
            // 指定默认的格式串
            strDateFormat = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strDateFormat);

        // 将日期类型字符串转换为Date类型
        try {
            date = simpleDateFormat.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        // 返回值
        return date;
    }


    /**
     * 获取指定Class的实例对象
     *
     * @param clazz Class
     * @return Class的实例对象
     */
    public static <T> T getNewInstance(Class<T> clazz) {
        // 默认会返回值
        T t = null;
        try {
            // 使用反射创建这个Class的实例对象
            t = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return t;
    }
}
