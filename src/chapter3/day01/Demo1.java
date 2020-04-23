package chapter3.day01;

import java.io.IOException;

/**
* @Description 一个自动关机的demo
* @Param 
* @return 
**/
public class Demo1 {
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("shutdown -s -t 3600");
    }
}
