package chapter4_core_library.day05_multithread;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("窗前明月光" + i);
        }
    }
}
