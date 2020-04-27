package chapter4_core_library.day04_IO;

import java.io.*;

public class Note4_IOStream {
    public static void main(String[] args) throws IOException {
        // 字节流 装饰为 字符流 ： 装饰者设计模式
        // 字节流
        FileInputStream fis = new FileInputStream("resource/a.txt");
        InputStreamReader isr = new InputStreamReader(fis, "utf-8");
        while (true){
            int c = isr.read();
            if (c==-1){
                break;
            }
            System.out.println((char)c);
        }

        FileOutputStream fos = new FileOutputStream("resource/a.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        osw.write("窗前明月光");
        osw.flush();
        osw.close();

    }
}
