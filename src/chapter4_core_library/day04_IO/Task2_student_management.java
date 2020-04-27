package chapter4_core_library.day04_IO;

import java.io.*;

public class Task2_student_management {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("123","shimin",26,"09-01", "123456");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("resource/student.txt"));
        oos.writeObject(student);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resource/student.txt"));
        Object o = ois.readObject();
        System.out.println(o);
    }

    static class Student implements Serializable{
        String number;
        String name;
        int age;
        String classTime;
        String tel;

        public Student(String number, String name, int age, String classTime, String tel) {
            this.number = number;
            this.name = name;
            this.age = age;
            this.classTime = classTime;
            this.tel = tel;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "number='" + number + '\'' +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", classTime='" + classTime + '\'' +
                    ", tel='" + tel + '\'' +
                    '}';
        }
    }
}
