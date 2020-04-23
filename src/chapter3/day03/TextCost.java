package chapter3.day03;

import java.util.Scanner;

public class TextCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入公里数：");
        int distance = sc.nextInt();
        System.out.println("请输入等候秒数：");
        int time = sc.nextInt();

        int disCost;
        if (distance<=3){
            disCost = 10;
        }else if (distance<=15){
            disCost = 10 + (distance-3)*2;
        }else {
            disCost = 34 + (distance-15)*3;
        }

        int timeCost = (time/150);
        System.out.println("总共的价格是" + (disCost+timeCost));
    }
}
