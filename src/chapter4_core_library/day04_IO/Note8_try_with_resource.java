package chapter4_core_library.day04_IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Note8_try_with_resource {
    public static void main(String[] args) throws FileNotFoundException {
        // 这样写就不用关了
        FileReader fr = new FileReader("resource/book.txt");
        PrintWriter pw = new PrintWriter("resource/book.txt");
        try(fr;pw){
            int c = fr.read();
            System.out.println((char)c);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
