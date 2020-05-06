package chapter3_logic_object.day05;
import java.util.Scanner;

public class Wuziqi {
    public static void main(String[] args) {
        //1.声明一个GoBand类型的引用指向该类的对象
        Wuziqi gb = new Wuziqi();
        //2.调用成员方法来绘制棋盘
        gb.paint();
        //3.调用成员方法来进行下棋
        gb.play();

    }
    //自定义二维数组来描述棋盘，默认初始值为0
    int[][] chessBoard = new int[16][16];

    //自定义成员方法来绘制棋盘
    void paint(){
        //1.先绘制棋盘中第一行的坐标信息，也就是列坐标信息
        for(int i = 0; i < 17; i++){
            if(i == 0){
                System.out.print("  ");
            }
            else{
                //按照十六进制的格式打印i-1的数值
                System.out.printf("%x ", i-1);
            }
        }
        System.out.println();

        //2.绘制棋盘中除了第一行之外的其他部分以及行坐标信息
        for(int i = 0; i < 16; i++){
            //用于打印行坐标信息
            System.out.printf("%x ", i);
            for(int j = 0; j < 16; j++){
                //刚开始棋盘中的所有内容都是+，因此直接打印
                if(chessBoard[i][j] == 0){
                    System.out.print("+ ");
                }
                else if(chessBoard[i][j] == 1){
                    System.out.print("● ");
                }
                else{
                    System.out.print("○ ");
                }
            }
            //打印完毕一行的所有内容之后进行换行
            System.out.println();
        }
    }

    //自定义成员方法来提示黑方和白方分别下棋
    void play(){
        //定义标志位来进行黑方和白方的切换，true代表黑方，false代表白方
        boolean flag = true;
        //不断地分别提示黑方和白方下棋
        while(true){
            System.out.println("请" + (flag ? "黑方": "白方") + "输入落子坐标(x y)：");
            Scanner sc = new Scanner(System.in);
            int ix = sc.nextInt();
            int iy = sc.nextInt();
            // 判断该位置是否已经有棋子
            if (chessBoard[ix][iy]!=0){
                System.out.println("该位置已经有棋子，请重新选择下子位置！");
                continue;
            }
            //根据用户输入的坐标来调整棋盘中的图案，策略为改变数组的元素值
            if(flag){
                //当黑方落子时就将数组中对应元素值改为1
                chessBoard[ix][iy] = 1;
            }else{
                //当白方落子时就将数组中对应元素改为2
                chessBoard[ix][iy] = 2;
            }
            //重新绘制图案
            paint();
            //判断当前方是否胜利，若胜利就立刻结束游戏
            if(judge(ix, iy)){
                System.out.println("恭喜" + (flag ? "黑方": "白方") + "胜利了！");
                break;
            }
            //此时切换下棋方
            flag = !flag;
        }
    }

    //自定义成员方法来判断用户是否获胜，获胜的规则是：任意相同颜色的5个棋子连成一线
    boolean judge(int ix, int iy){
        // 1.判断竖向
        int count = 1;
        for(int i = ix-1; i >= 0 && i >= ix-4; i--){
            if(chessBoard[ix][iy] != chessBoard[i][iy]){
                break;
            }
            count++;
        }
        for(int i = ix+1; i < 16 && i <= ix+4; i++){
            if(chessBoard[ix][iy] != chessBoard[i][iy]){
                break;
            }
            count++;
        }
        if (count>=5){
            return true;
        }

        // 2. 判断横向
        count = 1;
        for(int i = iy-1; i >= 0 && i >= iy-4; i--){
            if(chessBoard[ix][iy] != chessBoard[ix][i]){
                break;
            }
            count++;
        }
        for(int i = iy+1; i < 16 && i <= iy+4; i++){
            if(chessBoard[ix][iy] != chessBoard[ix][i]){
                break;
            }
            count++;
        }
        if (count>=5){
            return true;
        }

        // 3. 判断右下向
        count = 1;
        for(int i = ix-1, j=iy-1; i >= 0 && i >= ix-4 && j>=0 && j>=iy-4; i--, j--){
            if(chessBoard[ix][iy] != chessBoard[i][j]){
                break;
            }
            count++;
        }
        for(int i = ix+1, j=iy+1; i < 16 && i <= ix+4 && j<16 && j<=iy+4; i++, j++){
            if(chessBoard[ix][iy] != chessBoard[i][j]){
                break;
            }
            count++;
        }
        if (count>=5){
            return true;
        }

        // 4. 判断左下向
        count = 1;
        for(int i = ix+1, j=iy-1; i < 16 && i <= ix+4  && j>=0 && j>=iy-4; i++, j--){
            if(chessBoard[ix][iy] != chessBoard[i][j]){
                break;
            }
            count++;
        }
        for(int i = ix-1, j=iy+1; i >= 0 && i >= ix-4 && j<16 && j<=iy+4; i--, j++){
            if(chessBoard[ix][iy] != chessBoard[i][j]){
                break;
            }
            count++;
        }
        if (count>=5){
            return true;
        }

        //当所有可能胜利的情况都排除了，那么肯定是失败了
        return false;
    }
}
