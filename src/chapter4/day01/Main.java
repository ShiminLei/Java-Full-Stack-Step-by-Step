package chapter4.day01;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年：");
        int year = sc.nextInt();
        System.out.println("请输入月：");
        int month = sc.nextInt()-1;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = df.parse("2016-01-01");

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int weekStart = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println("日\t\t一\t\t二\t\t三\t\t四\t\t五\t\t六");
        for (int i=1;i<weekStart;i++){
            System.out.printf("%-8s","");
        }

        int countRelax = 0;
        int countWeekend = 0;
        int maxDate = calendar.getActualMaximum(Calendar.DATE);
        for (int i=1;i<= maxDate;i++){
            calendar.set(Calendar.DAY_OF_MONTH, i);
            Date temp = calendar.getTime();
            int gap = getGapDay(startDate, temp);
            if (gap%4==1){
                System.out.printf("%-8s","["+calendar.get(Calendar.DAY_OF_MONTH)+"]");
                countRelax++;
                if (calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
                    countWeekend++;
                }
            }else {
                System.out.printf("%-8s", calendar.get(Calendar.DAY_OF_MONTH));
            }

            if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
                System.out.println();
            }
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }
        System.out.println("本月休息的天数有："+countRelax);
        System.out.println("本月轮到周末休息的天数有："+countWeekend);

    }

    private static int getGapDay(Date from, Date to){
        long fromTime = from.getTime();
        long toTime = to.getTime();
        int days = (int) ((toTime - fromTime) / (1000 * 60 * 60 * 24));
        return days;
    }
}