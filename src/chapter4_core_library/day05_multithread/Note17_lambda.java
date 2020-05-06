package chapter4_core_library.day05_multithread;

public class Note17_lambda {

    public static void main(String[] args) {
//        Thread t = new Thread(() -> System.out.println("锄禾日当午"));

        print((int x, int y) -> {return x+y;}, 1,2);
    }

    public static void print(MyMath m, int x, int y){
        int sum = m.sum(x, y);
        System.out.println(sum);
    }

    static interface MyMath{
        int sum(int x, int y);
    }
}
