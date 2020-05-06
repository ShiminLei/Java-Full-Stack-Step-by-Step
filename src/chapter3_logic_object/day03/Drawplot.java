package chapter3_logic_object.day03;

public class Drawplot {
    public static void main(String[] args) {
        // draw plot 1
        System.out.println("画第一个图：");
        for (int i=0; i<5; i++){
            for (int j=0; j<=i; j++){
                System.out.print('*');
            }
            System.out.print('\n');
        }

        // draw plot 2
        System.out.println("画第二个图：");
        for (int i=0; i<5; i++){
            for (int j=4-i; j>=0; j--){
                System.out.print('*');
            }
            System.out.print('\n');
        }

        //draw plot 3
        System.out.println("画第三个图：");
        for (int i=0; i<=5; i++){
            for (int j=4-i; j>=0; j--){
                System.out.print(' ');
            }
            for (int j=0; j<i*2-1; j++){
                System.out.print('*');
            }
            System.out.print('\n');
        }
    }
}
