package chapter3_logic_object.day03;

public class Chengfabiao {
    public static void main(String[] args) {
        for (int i=1; i<=9; i++){
            for (int j=1; j<=i; j++){
                System.out.print(""+j+"*"+i+"="+i*j+"   ");
            }
            System.out.println();
        }
    }
}
