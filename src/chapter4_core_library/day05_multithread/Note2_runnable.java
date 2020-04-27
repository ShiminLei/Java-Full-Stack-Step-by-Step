package chapter4_core_library.day05_multithread;

public class Note2_runnable {
    /*
    实现 Runnable 比 继承 Thread 的好处：
    1。通关创建任务，更加适合多个线程同时执行相同任务的情况
    2。可以避免单继承所带来的局限性
    3。任务与线程分离，健壮性
    4。后续的线程池，只接受 Runnable
     */
    public static void main(String[] args) {
        // 1. 创建一个任务对象
        MyRunnable r = new MyRunnable();
        // 2. 创建一个线程，并为其分配一个任务
        Thread t = new Thread(r);
        t.start();
        for (int i=0; i<10; i++){
            System.out.println("疑是地上霜" + i);
        }
    }
}
