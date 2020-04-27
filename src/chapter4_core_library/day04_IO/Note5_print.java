package chapter4_core_library.day04_IO;

import java.io.*;

public class Note5_print {
    public static void main(String[] args) throws IOException {
        PrintStream ps = new PrintStream("resource/c.txt");
        ps.println("锄禾日当午");
        ps.println("汗滴禾下土");

//      字符流 一定要 flush
//        PrintWriter pw = new PrintWriter("resource/c.txt");
//        pw.println("锄禾日当午");
//        pw.println("汗滴禾下土");
//        pw.flush();

        FileOutputStream fos = new FileOutputStream("resource/c.txt");
        PrintWriter pw = new PrintWriter(fos);
        pw.println("锄禾日当午");
        pw.println("汗滴禾下土");
        pw.flush();

        // 缓存字符流，可以一次读取一行
        FileReader fr = new FileReader("resource/c.txt");
        BufferedReader br = new BufferedReader(fr);
        String text = br.readLine();
        System.out.println(text);
    }
}
