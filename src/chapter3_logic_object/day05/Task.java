package chapter3_logic_object.day05;

import java.util.*;

public class Task {
    public static void main(String[] args) {
//        palindrome("12322");
//        swap(10, 89);
//        cost();
//        sum(254);
//        plot();
//        prime();
//        inverse(452);
//        fibo(3);
//        twoSum(new int[]{1,2,3}, 3);
//        shuangseqiu();
//        duizhang(6);

    }



    /**
     * 选队长
     * @param n
     */
    private static void duizhang(int n){
        int left = n;
        int i = -1;
        boolean[] f = new boolean[n];
        while (left > 1){
            for (int j=0; j<3; j++){
                i = step(f, i);
                while (f[i]==true){
                    i = step(f, i);
                }
            }
            f[i] = true;
//            System.out.println(i+1);
            left--;
        }
        while (f[i]==true){
            i = step(f, i);
        }
        System.out.println(i+1);
    }

    /**
     * 选队长-辅助函数
     * @param f
     * @param i
     * @return
     */
    private static int step(boolean[] f, int i){
        if (i<f.length-1){
            i++;
        }else{
            i = 0;
        }
        return i;
    }



    /**
     * 双色球游戏
     */
    private static void shuangseqiu(){
        int[] my = new int[7];
        int[] nums = new int[7];
        Set<Integer> seen = new HashSet<>();
        System.out.println("请输入你买的7个彩票数字");
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        for (int i=0; i<7; i++){
            my[i] = sc.nextInt();
            if (i!=7){
                 int temp = rd.nextInt(33)+1;
                 while (seen.contains(temp)){
                     temp = rd.nextInt(33)+1;
                 }
                 nums[i] = temp;
                 seen.add(temp);
            }else {
                nums[i] = rd.nextInt(16)+1;
            }
        }
        System.out.println("你买的号码是");
        for (int num: my){
            System.out.print(""+num + " ");
        }
        System.out.println("\n中奖号码是");
        for (int num: nums){
            System.out.print(""+num + " ");
        }
        //
        int count1 = 0;
        for (int i=0; i<6; i++){
            if (seen.contains(my[i])){
                count1++;
            }
        }
        int count2 = 0;
        if (my[6]==nums[6]){
            count2++;
        }
        System.out.println("您的中奖情况是：");
        if (count1==6 && count2==1){
            System.out.println("一等奖");
        }else if (count1==6 && count2==0){
            System.out.println("二等奖");
        }else if (count1==5 && count2==1){
            System.out.println("三等奖");
        }else if (count1==5 || (count1==4 && count2==1)){
            System.out.println("四等奖");
        }else if (count1==4 || (count1==3 && count2==1)){
            System.out.println("五等奖");
        }else if (count2==1 && (count1>=0 && count1<=2)){
            System.out.println("六等奖");
        }else{
            System.out.println("没中奖");
        }
    }

    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<n; i++){
            if (map.get(target-nums[i])!=null){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }

    /**
     * 斐波那契数列
     * @param n
     */
    private static void fibo(int n){
        int[] f = new int[n];
        f[0] = 0;
        System.out.println(0);
        if (n==1)return;
        f[1] = 1;
        System.out.println(1);
        if (n==2)return;
        for (int i=2; i<n; i++){
            f[i] = f[i-1] + f[i-2];
            System.out.println(f[i]);
        }

    }


    /**
     * 逆序打印数字
     * @param num
     */
    private static void inverse(int num){
        int count = 1;
        while (num>=10){
            int mod = num%10;
            num = num/10;
            System.out.println(mod);
            count++;
        }
        System.out.println(num);
        System.out.println("总共的位数是"+count);
    }

    /**
     * 找100 以内的质数
     */
    private static void prime(){
        System.out.println(2);
        for (int i=3; i<=100;i++){
            boolean flag = true;
            for (int j=2; j*j<=i; j++ ){
                if (i%j==0 && i!=j){
                    flag = false;
                    break;
                }
            }
            if (flag) System.out.println(i);
        }
    }

    /**
     * 画菱形
     */
    private static void plot(){
        for (int i=0; i<=4; i++){
            for (int j=4-i; j>=0; j--){
                System.out.print(' ');
            }
            for (int j=0; j<i*2-1; j++){
                System.out.print('*');
            }
            System.out.print('\n');
        }
        for (int i=2; i>=0; i--){
            for (int j=0; j<4-i; j++){
                System.out.print(' ');
            }
            for (int j=i*2; j>=0; j--){
                System.out.print('*');
            }
            System.out.print('\n');
        }
    }

    /**
     * 计算各位之和
     * @param num
     * @return
     */
    private static int sum(int num){
        int sum = 0;
        while (num>=10){
            int mod = num%10;
            num = num/10;
            sum += mod;
        }
        sum += num;
        System.out.println(sum);
        return sum;
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
