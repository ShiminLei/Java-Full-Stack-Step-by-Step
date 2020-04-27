package chapter4_core_library.day05_multithread;

public class Note5_shouhu {
    // 线程： 分为 守护线程 用户线程
    // 用户线程： 当一个进程不包含任何存活的用户线程时，进程结束
    // 守护线程： 守护用户线程的， 当最后一个用户线程结束时，所有守护线程自动死亡
    public static void main(String[] args) {
        Thread t1= new Thread(new MyRunnable());
        // 设置为守护线程
        t1.setDaemon(true);
        t1.start();
        for (int i=0; i<=5; i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            for (int i=0; i<10; i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
