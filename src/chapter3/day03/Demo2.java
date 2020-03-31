package day03;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        if (s>=60){
            System.out.println("合格");
        }else{
            System.out.println("不合格");
        }
    }
}
