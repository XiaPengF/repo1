package com.xpf.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Xia
 * @Date: 2019/12/31 9:33
 * @Email：x2358114512@163.com
 */
public class DateUtils {

    //日期转换为字符串
    public static String date2String(Date date, String patten){
        SimpleDateFormat dateFormat = new SimpleDateFormat(patten);
        String format = dateFormat.format(date);
        return format;
    }

    //字符串转换为日期
    public static Date string2Date(String str, String patten)throws Exception{
        SimpleDateFormat dateFormat = new SimpleDateFormat(patten);
        Date format = dateFormat.parse(str);
        return format;
    }
}
