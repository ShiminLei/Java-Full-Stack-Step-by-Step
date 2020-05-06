package chapter4_core_library.day06_web_programming.kuaidi.view;

import chapter4_core_library.day06_web_programming.kuaidi.bean.Express;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

public class Views {

    private Scanner input;
    private PrintStream ps;

    public Views() {
        input = new Scanner(System.in);
    }

    public void welcome(){
        System.out.println("欢迎使用快递管理系统～");
    }

    public void bye(){
        System.out.println("欢迎下次再次使用～");
    }

    /**
     * 选择身份的菜单
     * @return
     */
    public int menu(){
        System.out.println("请根据提示，输入功能序号");
        System.out.println("1. 快递员");
        System.out.println("2. 普通用户");
        System.out.println("0. 退出");
        String text = input.nextLine();
        int num = -1;
        try{
            num = Integer.parseInt(text);
        }catch (NumberFormatException e){

        }
        if (num<0 || num>2){
            System.out.println("输入有误请重新检查");
            return menu();
        }else {
            return num;
        }
    }

    /**
     * 快递员的菜单
     * @return
     */
    public int cMenu(){
        System.out.println("请根据提示，输入功能序号");
        System.out.println("1. 快递员录入");
        System.out.println("2. 快递修改");
        System.out.println("3. 快递删除");
        System.out.println("4. 查看所有快递");
        System.out.println("0. 返回上级目录");
        String text = input.nextLine();
        int num = -1;
        try{
            num = Integer.parseInt(text);
        }catch (NumberFormatException e){

        }
        if (num<0 || num>4){
            System.out.println("输入有误请重新检查");
            return cMenu();
        }else {
            return num;
        }
    }

    /**
     * 快递员录入快递
     * @return 包含了快递单号和快递公司的录入对象
     */
    public Express insert(){
        System.out.println("请根据提示，输入快递信息");
        System.out.println("请输入快递单号：");
        String number = input.nextLine();
        System.out.println("请输入快递公司：");
        String company = input.nextLine();
        Express express = new Express();
        express.setCompany(company);
        express.setNumber(number);
        return express;
    }

    /**
     * 提示用户输入快递单号
     * @return
     */
    public String findByNumber(){
        System.out.println("请根据提示，输入快递信息");
        System.out.println("请输入要操作的快递单号：");
        String number = input.nextLine();
        return number;
    }

    /**
     * 显示快递信息
     * @param e
     */
    public void printExpress(Express e){
        System.out.println("快递信息如下：");
        System.out.println(e);
    }

    public void printNull(){
        System.out.println("快递不存在，请检查您的输入");
    }

    /**
     * 修改快递信息
     * @param e
     */
    public void update(Express e){
        System.out.println("请输入新的快递单号：");
        String number = input.nextLine();
        System.out.println("请输入新的快递公司：");
        String company = input.nextLine();
        e.setNumber(number);
        e.setCompany(company);
    }

    /**
     * 询问是否删除
     * @return
     */
    public int delete(){
        System.out.println("是否确认删除：");
        System.out.println("1. 确认删除");
        System.out.println("2. 取消操作");
        String text = input.nextLine();
        int num = -1;
        try{
            num = Integer.parseInt(text);
        }catch (NumberFormatException e){

        }
        if (num<1 || num>2){
            System.out.println("输入有误请重新检查");
            return delete();
        }else {
            return num;
        }
    }

    /**
     * 快递信息遍历显示
     */
    public void printAll(Express[][] expresses){
        int count = 0;
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                if (expresses[i][j]!=null){
                    count++;
                    System.out.println("位置：" + i + "," + j);
                    printExpress(expresses[i][j]);
                }
            }
        }
        if (count==0){
            System.out.println("暂无快递信息");
        }
    }

    /**
     * 用户的菜单
     * @return
     */
    public int uMenu(){
        System.out.println("请根据提示，进行取件");
        System.out.println("请输入您的取件码：");
        String code = input.nextLine();
        int num = -1;
        try{
            num = Integer.parseInt(code);
        }catch (NumberFormatException e){

        }
        if (num<100000 || num>999999){
            System.out.println("输入有误请重新检查");
            return uMenu();
        }else {
            return num;
        }
    }

    /**
     * 快递已经存在
     */
    public void expressExist(){
        System.out.println("此单号在快递柜中已存在，请检查单号是否有误");
    }

    public void printCode(Express express){
        System.out.println("快件的取件码为："+express.getCode());
    }

    public void success(){
        System.out.println("操作成功");
    }

}
