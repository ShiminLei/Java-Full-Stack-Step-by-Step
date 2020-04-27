package chapter4_core_library.day04_IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Note6_property {
    public static void main(String[] args) throws IOException {
        Properties ppt = new Properties();
        ppt.put("a", "1111");
        ppt.put("b", "222");
        FileWriter fw = new FileWriter("resource/ppt.txt");
        ppt.store(fw, "键值对");
        fw.close();

        Properties ppt2 = new Properties();
        Reader r = new FileReader("resource/ppt.txt");
        ppt2.load(r);
        System.out.println(ppt.get("a"));
    }
}
