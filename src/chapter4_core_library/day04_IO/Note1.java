package chapter4_core_library.day04_IO;

import java.io.File;
import java.io.IOException;

public class Note1 {
    public static void main(String[] args) throws IOException {
        File file = new File("text.txt");
        boolean flag = file.createNewFile();
        file.delete();

        File dir = new File("dir");
        dir.mkdir();

        File a  = new File(dir, "a.txt");
        a.createNewFile();

        File b  = new File("dir", "b.txt");
        b.createNewFile();

        a.delete();
        b.delete();
        dir.delete();

        File cc = new File("dir/aa/bb/cc");
        cc.mkdirs();
        File ee = new File("dir/aa/ee");
        cc.renameTo(ee); // rename to 移动文件

        System.out.println(File.pathSeparator);
        System.out.println(File.separator);

    }
}
