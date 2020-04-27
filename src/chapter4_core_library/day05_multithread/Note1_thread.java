package chapter4_core_library.day05_multithread;

public class Note1_thread {
    public static void main(String[] args) {
        MyThread m = new MyThread();
        m.start();
        for (int i=0; i<10; i++){
            System.out.println("aaaaaaaaa"+i);
        }
    }
}
