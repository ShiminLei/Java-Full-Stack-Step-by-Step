package chapter4_core_library.day04_IO;

import java.io.File;
import java.io.FileFilter;

public class Note2 {

    public static void main(String[] args) {
        File e = new File(".");
        File[] files = e.listFiles();
        if (files!=null && files.length>0){
            for (File file: files){
                if (file.getName().endsWith(".md")) {
                    System.out.println(file.getName());
                }
            }
        }

        e.getAbsolutePath();

        // 文件的过滤
        MdFilter mdFilter = new MdFilter();
        e.listFiles(mdFilter);

    }

    static class MdFilter implements FileFilter{
        @Override
        public boolean accept(File pathname) {
            if (pathname.getName().endsWith(".md")||pathname.isDirectory()){
                return true;
            }
            return false;
        }
    }
}
