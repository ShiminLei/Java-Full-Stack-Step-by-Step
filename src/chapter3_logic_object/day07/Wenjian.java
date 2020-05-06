package chapter3_logic_object.day07;

import java.io.*;

public class Wenjian {
    public static void main(String[] args) throws IOException {
//        File file = new File("src/chapter3/day07/file.txt");
//        file.createNewFile();
//        file.isFile(); // 判断是文件还是文件夹
//        file.delete();

        File file = new File("src/chapter3/day07/file.txt");
        file.createNewFile();
        FileWriter fw = new FileWriter(file);
        fw.write("s");
        fw.flush(); // 把缓存区的内容，放到文件里
        fw.write("s");
        fw.flush();
        fw.close();

        FileReader fr = new FileReader(file);
        // 转换能一次读取一行的 reader
        BufferedReader br = new BufferedReader(fr);
        String text = br.readLine();
        System.out.println(text);




    }
}
