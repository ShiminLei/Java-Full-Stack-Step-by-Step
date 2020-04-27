package chapter4_core_library.day04_IO;

import java.io.*;

public class Note7_serialize {
    /*
    序列化 与 反序列化
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Book book = new Book("apple", "grow apple~!");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("resource/book.txt"));
        oos.writeObject(book);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resource/book.txt"));
        Object o = ois.readObject();
        System.out.println(o);
    }

    static class Book implements Serializable {
        String name;
        String info;
        Book(String name, String info){
            this.name = name;
            this.info = info;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "name='" + name + '\'' +
                    ", info='" + info + '\'' +
                    '}';
        }
    }
}
