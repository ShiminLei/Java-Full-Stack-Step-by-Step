package chapter3.day03;

public class Shuixianhua {
    public static void main(String[] args) {
        for (int i=100; i<=999; i++){
            int a = i/100;
            int b = (i - a*100)/10;
            int c = i-a*100-b*10;
            if (a*a*a+b*b*b+c*c*c==i){
                System.out.println(i);
            }
        }
    }
}
