package chapter4.day01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Task {
    public static void main(String[] args) throws ParseException {
        //获取当前的日期,并把这个日期转换为指定格式的字符串,如2088-08-08 08:08:08。
        Date now = new Date();
        System.out.println(now);
        System.out.println(now.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String text = format.format(now);
        System.out.println(text);

        //把2020-03-04转换为2020年03月04日
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = format2.parse("2020-03-04");
        SimpleDateFormat format3 = new SimpleDateFormat("yyyy年MM月dd日");
        String text2 = format3.format(date);
        System.out.println(text2);

        //用程序判断2018年2月14日是星期几
        Calendar cl = Calendar.getInstance();
        int year = cl.get(Calendar.YEAR);
        int day = cl.get(Calendar.DAY_OF_YEAR);
        cl.set(Calendar.YEAR, 2018);
        cl.set(Calendar.MONTH, 2);
        cl.set(Calendar.DAY_OF_MONTH, 14);
        System.out.println(cl.get(Calendar.WEDNESDAY));


    }


}
