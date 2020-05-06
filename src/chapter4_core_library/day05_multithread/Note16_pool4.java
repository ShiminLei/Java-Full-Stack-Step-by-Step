package chapter4_core_library.day05_multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Note16_pool4 {
    // 4. 周期定长线程池
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        /**
         * 定时执行一次
         * 参数1：定时执行的任务
         * 参数2：时长数字
         * 参数3：时长数字的时间单位
         */
//        service.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("锄禾日当午");
//            }
//        }, 5, TimeUnit.SECONDS); // 任务在5秒钟后执行

        /**
         * 周期性执行任务
         * 参数1：定时执行的任务
         * 参数2：延迟时长数字 (第一次执行在多少时间以后
         * 参数3：周期时长数字
         * 参数4：时长数字的时间单位
         */
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("锄禾日当午");
            }
        }, 5, 1,TimeUnit.SECONDS);
    }
}
