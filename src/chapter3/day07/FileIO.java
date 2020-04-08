package chapter3.day07;

import java.io.*;

public class FileIO {
    public static void main(String[] args) throws IOException {
        File file = new File("src/chapter3/day07/text.txt");
        FileInputStream fis = new FileInputStream(file);
        // 写入文件
        byte[] bytes = new byte[(int)file.length()];
        fis.read(bytes);
        // 写出文件
        File file2 = new File("src/chapter3/day07/text2.txt");
        FileOutputStream fos = new FileOutputStream(file2);
        fos.write(bytes, 0, 3); // 开始的下标，写入的数组的长度

        // 用完一定要关闭
        fis.close();
        fos.close();

    }
}
