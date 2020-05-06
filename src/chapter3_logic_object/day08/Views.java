package chapter3_logic_object.day08;

public class Views {
    public Views() {
    }

    public void welcome() {
        System.out.println("===========================");
        System.out.println("======= 欢迎来到ATM机 =======");
        System.out.println("============================");
    }

    public void menu(){
        System.out.println("请输入编号选择你需要的操作。");
        System.out.println("1. 注册");
        System.out.println("2. 查询");
        System.out.println("3. 取款");
        System.out.println("4. 存款");
        System.out.println("5. 转账");
        System.out.println("6. 锁卡");
        System.out.println("7. 解卡");
        System.out.println("8. 补卡");
        System.out.println("9. 改密");
        System.out.println("10. 退出");
    }
}
