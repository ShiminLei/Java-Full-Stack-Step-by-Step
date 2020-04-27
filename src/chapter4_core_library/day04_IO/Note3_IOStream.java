package chapter4_core_library.day04_IO;

import java.io.*;

public class Note3_IOStream {
    // 字节流：InputStream, OutputStream
    // 字符流: Reader, Writer
    // 一切皆字节, 所有流的底层都是二进制
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("text.txt"); // 如果 append = true, 会接着写
        byte[] bytes = {65, 66, 67, 68};
        fos.write(bytes);
        byte[] by = "abcd".getBytes();
        fos.write(by,1,3);
        fos.close();

        FileWriter fw = new FileWriter("text.txt");
        fw.append("aaaaaa");
        fw.flush();//清除缓存
        fw.close();

        FileReader fr = new FileReader("text.txt");
//        while (true){
//            int c = fr.read(); // 一次读一个字符
//            if (c==-1){
//                break;
//            }
//            System.out.println((char)c);
//        }

        char[] chars = new char[100];
        int length = fr.read(chars); // 把text 读到数组里面
        System.out.println(length);
        System.out.println(new String(chars));

    }


}
