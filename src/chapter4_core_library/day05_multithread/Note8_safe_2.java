package chapter4_core_library.day05_multithread;

public class Note8_safe_2 {
    // 解决方案2： 同步方法
    public static void main(String[] args) {
        Runnable run = new Ticket();
        new Thread(run).start();
        new Thread(run).start();
        new Thread(run).start();
    }

    static class Ticket implements Runnable{
        private int count = 10;

        @Override
        public void run() {
            while (true){
                boolean flag = sale();
                if (!flag){
                    break;
                }
            }

        }

        public synchronized boolean sale(){
            if (count>0){
                System.out.println("正在准备卖票");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
                System.out.println(Thread.currentThread().getName()+"出票成功，余票 "+count);
                return true;
            }else {
                return false;
            }
        }
    }
}
