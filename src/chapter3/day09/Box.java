package chapter3.day09;

import java.util.Random;

public class Box {
    String pos;

    public Box() {
        pos = generatePos();
    }

    private String generatePos(){
        Random rd = new Random();
        String takeNum = "";
        for (int i=0; i<10; i++){
            takeNum += rd.nextInt(10);
        }
        return takeNum;
    }

    @Override
    public String toString() {
        return "Box{" +
                "pos='" + pos + '\'' +
                '}';
    }
}
