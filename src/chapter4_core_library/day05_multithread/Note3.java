package chapter4_core_library.day05_multithread;

public class Note3 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        new Thread(new MyRunnable(),"a").start();
        new Thread(new MyRunnable(),"b").start();
        new Thread(new MyRunnable(),"c").start();

        // 线程的休眠
        for (int i=0; i<10; i++){
            System.out.println(i);
            Thread.sleep(1000);
        }

        // 线程阻塞： 比如读取文件
    }

    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}
