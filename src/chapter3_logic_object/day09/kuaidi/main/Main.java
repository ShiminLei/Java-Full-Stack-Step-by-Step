package chapter3_logic_object.day09.kuaidi.main;

import chapter3_logic_object.day09.kuaidi.bean.Express;
import chapter3_logic_object.day09.kuaidi.dao.ExpressDao;
import chapter3_logic_object.day09.kuaidi.view.Views;

public class Main {
    private static Views views;
    private static ExpressDao dao;

    public Main() {
        views = new Views();
        dao = new ExpressDao();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start() {
        // 1. 欢迎
        views.welcome();
        m: while (true){
            int menu = views.menu();
            switch (menu){
                case 0:
                    break m;
                case 1:
                    cClient();
                    break;
                case 2:
                    uClient();
                    break;
            }
        }
        dao.save();
        views.bye();
    }

    private static void uClient() {
        // 1. 取件码的获取
        int code = views.uMenu();
        //  2. 根据取件码查出快递
        Express express = dao.findByCode(code);
        if (express==null){
            views.printNull();
        }else {
            views.success();
            views.printExpress(express);
            dao.delete(express);
        }
    }

    private static void cClient() {
        while (true){
            int menu = views.cMenu();
            switch (menu){
                case 0:
                    return;
                case 1:{
                    Express express = views.insert();
                    Express express1 = dao.findByNumber(express.getNumber());
                    if (express1==null){
                        dao.add(express);
                        views.printExpress(express);
                    }else {
                        // 快递已存在
                        views.expressExist();
                    }
                }
                    break;
                case 2:{
                    // 快递修改
                    String number = views.findByNumber();
                    Express express = dao.findByNumber(number);
                    Express express1 = express;
                    if (express==null){
                        views.printNull();
                    }else{
                        views.printExpress(express);
                        views.update(express1);
                        dao.update(express, express1);
                        views.printExpress(express1);
                    }
                }
                    break;
                case 3:{
                    // 删除
                    String number = views.findByNumber();
                    Express express = dao.findByNumber(number);
                    if (express==null){
                        views.printNull();
                    }else{
                        views.printExpress(express);
                        int type = views.delete();
                        if (type==1){
                            dao.delete(express);
                            views.success();
                        }
                    }
                }
                    break;
                case 4: {
                    Express[][] data = dao.findAll();
                    views.printAll(data);
                }
                    break;
            }
        }
    }


}
