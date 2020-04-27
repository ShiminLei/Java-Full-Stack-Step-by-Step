package chapter4_core_library.day05_multithread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Note9_lock {
    // 解决方案2： 同步方法
    public static void main(String[] args) {
        Runnable run = new Ticket();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    static class Ticket implements Runnable{
        private int count = 10;
        Lock l = new ReentrantLock(true); // 公平锁

        @Override
        public void run() {
            while (true){
                l.lock();
                if (count>0){
                    System.out.println("正在准备卖票");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count--;
                    System.out.println(Thread.currentThread().getName()+"出票成功，余票 "+count);
                }else {
                    System.out.println("break");
                    break;
                }
                l.unlock();
                System.out.println("unlock");
            }


        }

    }
}
