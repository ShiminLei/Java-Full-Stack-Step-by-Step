package chapter4_core_library.day05_multithread;

public class Note4_interrupt {
    public static void main(String[] args) {
        Thread t1= new Thread(new MyRunnable());
        t1.start();
        for (int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        // 给线程添加中断标记
        t1.interrupt();

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
//                    System.out.println("发现了中断标记，但就是不死亡");
                    System.out.println("发现了中断标记，选择return 死亡");
                    return;
                }
            }
        }
    }
}
