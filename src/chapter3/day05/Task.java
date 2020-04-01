package chapter3.day05;

import java.util.Scanner;

public class Task {
    public static void main(String[] args) {
        palindrome("12322");
        swap(10, 89);
        cost();
    }



    /**
     * 计算打折金额
     */
    private static void cost(){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        double cost;
        if (m<0){
            System.out.println("请输入合法数值");
        }else{
            if (m<=2000){
                cost = m*0.9;
            }else if (m<=4000){
                cost = m*0.8;
            }else if (m<=8000){
                cost = m*0.75;
            }else{
                cost = m*0.7;
            }
            System.out.println("打折后的金额是"+cost);
        }
    }

    /**
     * 互换两个整数
     * @param a
     * @param b
     */
    private static void swap(int a, int b){
        System.out.println(a);
        System.out.println(b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a);
        System.out.println(b);
    }

    /**
     * 判断回文数
     * @param num
     */
    private static void palindrome(String num){
        char[] array = num.toCharArray();
        int i = 0;
        int j = array.length-1;
        while (i<=j){
            if (array[i]==array[j]){
                i++;
                j--;
            }else {
                System.out.println(num+"不是回文数");
                return;
            }
        }
        System.out.println(num+"是回文数");
    }
}
