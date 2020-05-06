package chapter4_core_library.day05_multithread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Note12_callable {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> c = new MyCallable();
        FutureTask<Integer> task = new FutureTask<>(c);
//        task.isDone();
//        task.cancel(true);
        new Thread(task).start();
        Integer j =task.get();
        System.out.println("返回值为"+j);
        // 主线程会等子线程返回之后再执行
        for (int i=0; i<10; i++){
            Thread.sleep(100);
            System.out.println(i);
        }
    }



    static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
//            Thread.sleep(3000);
            for (int i=0; i<10; i++){
                System.out.println(i);
            }
            return 100;
        }
    }
}
