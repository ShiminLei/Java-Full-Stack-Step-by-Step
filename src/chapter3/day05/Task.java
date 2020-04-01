package chapter3.day05;

public class Task {
    public static void main(String[] args) {
        palindrome("12322");
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
