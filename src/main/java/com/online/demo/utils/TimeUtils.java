package com.online.demo.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

// 时间工具类
public class TimeUtils {

    // 获取指定时间的时间戳， --  精确到天
    public static Long getTimeForTimestamp(LocalDateTime dateDay) {

        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String currTimeStr = dateDay.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            Date date = df.parse(currTimeStr);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);

            long timestamp = cal.getTimeInMillis()/1000l;

            return timestamp;
        }catch (Exception e){
            return 0l;
        }
    }

    // 时间戳转当前天
    // TODO 还没写

    public static void main(String[] args) throws Exception{
        System.out.println(TimeUtils.getTimeForTimestamp(LocalDateTime.now()));
    }

}
