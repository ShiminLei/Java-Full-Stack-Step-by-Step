package chapter4_core_library.day05_multithread;

import java.io.FileReader;

public class Note11_tongxin {
    public static void main(String[] args) {
        Food food = new Food();
        new Cook(food).start();
        new Waiter(food).start();
    }

    static class Cook extends Thread{
        private Food food;
        public Cook(Food food){
            this.food = food;
        }

        @Override
        public void run() {
            for (int i=0; i<100; i++){
                if (i%2==1){
                    food.setNameTaste("老干妈", "香辣味");
                }else{
                    food.setNameTaste("煎饼果子", "甜辣味");
                }
            }
        }
    }

    static class Waiter extends Thread{
        private Food food;
        public Waiter(Food food){
            this.food = food;
        }

        @Override
        public void run() {
            for (int i=0; i<100; i++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                food.get();
            }
        }
    }

    static class Food{
        private String name;
        private String taste;
        private boolean flag = true; // true 表示可以生产

        public synchronized void setNameTaste(String name, String taste){
            if (flag){
                this.name = name;
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.taste = taste;
                flag = false;
                this.notifyAll();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public synchronized void get(){
            if (!flag){
                System.out.println("服务员端走的菜的名字是："+name + "， 味道是："+taste);
                flag = true;
                this.notifyAll();
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
