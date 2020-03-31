package day02;

public class Demo1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int temp = a;
        a = b;
        b = temp;
        System.out.println(a);
        System.out.println(b);

        byte b1 = 127;
        int b2 = b1;
        System.out.println(b2);

        float f1 = 10.1f;
        long l1 = 2000000000000l;
    }
}
