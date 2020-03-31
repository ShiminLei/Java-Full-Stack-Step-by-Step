package day03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入年份：");
        int year = sc.nextInt();
        System.out.println("请输入月份：");
        int month = sc.nextInt();
        Set<Integer> month1 = new HashSet<>(Arrays.asList(1,3,5,7,8,10,12));
        Set<Integer> month2 = new HashSet<>(Arrays.asList(4,6,9,11));

        System.out.println("本月的天数是：");
        if (month1.contains(month)){
            System.out.println(31);
        }else if (month2.contains(month)){
            System.out.println(30);
        }else {
            if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                System.out.println(29);
            } else {
                System.out.println(28);
            }
        }

    }
}
