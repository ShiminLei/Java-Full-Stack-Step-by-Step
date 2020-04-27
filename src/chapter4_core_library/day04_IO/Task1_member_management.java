package chapter4_core_library.day04_IO;

import java.io.*;

public class Task1_member_management {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Member member = new Member("111", "shimin", "123456", 100, "1993-08-30");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("resource/member.txt"));
        oos.writeObject(member);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resource/member.txt"));
        Object o = ois.readObject();
        System.out.println(o);
    }


    static class Member implements Serializable{
        String number;
        String name;
        String Id;
        int money;
        String date;

        Member(String number, String name, String Id, int money, String date){
            this.number = number;
            this.name = name;
            this.Id = Id;
            this.money = money;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Member{" +
                    "number='" + number + '\'' +
                    ", name='" + name + '\'' +
                    ", Id='" + Id + '\'' +
                    ", money=" + money +
                    ", date='" + date + '\'' +
                    '}';
        }
    }
}
