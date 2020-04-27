package chapter4_core_library.day05_multithread;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("bbbbbbbbb"+i);
        }
    }
}
