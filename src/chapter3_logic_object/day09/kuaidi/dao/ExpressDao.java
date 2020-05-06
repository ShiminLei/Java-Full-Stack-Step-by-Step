package chapter3_logic_object.day09.kuaidi.dao;

import chapter3_logic_object.day09.kuaidi.bean.Express;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

public class ExpressDao {

    private Express[][] data;
    private int size;
    private Random random = new Random();

    public ExpressDao() {
        try{
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resource/express.ser"));
            data = (Express[][])ois.readObject();
            size = countSize(data);
        }catch (Exception e){
            data = new Express[10][];
            for (int i=0; i<10; i++){
                data[i] = new Express[10];
            }
            size = 0;
        }
    }

    public void save() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("resource/express.ser"));
            oos.writeObject(data);
            System.out.println("储存数据成功！");
        }catch (Exception e){
            System.out.println("储存数据失败！");
        }
    }

    private static int countSize(Express[][] data){
        int size = 0;
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                if (data[i][j]!=null){
                    size++;
                }
            }
        }
        return size;
    }

    public boolean add(Express express){
        if (size==100){
            return false;
        }
        // 1. 随机生成 2 个 0-9 的下标
        int x = -1;
        int y = -1;
        while (true){
            x = random.nextInt(10);
            y = random.nextInt(10);
            if (data[x][y]==null){
                break;
            }
        }
        // 2. 取件码
        int code = randomCode();
        express.setCode(code);
        data[x][y] = express;
        return true;
    }

    private int randomCode(){
        while (true){
            int code = random.nextInt(900000)+100000;
            Express express = findByCode(code);
            if (express==null){
                return code;
            }
        }

    }

    public Express findByNumber(String number){
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                if (data[i][j]!=null && data[i][j].getNumber().equals(number)){
                    return data[i][j];
                }
            }
        }
        return null;
    }

    public Express findByCode(int code){
        for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                if (data[i][j]!=null && data[i][j].getCode()==code){
                    return data[i][j];
                }
            }
        }
        return null;
    }

    /**
     * 多余的操作
     * @param oldExpress
     * @param newExpress
     */
    public void update(Express oldExpress, Express newExpress){
        delete(oldExpress);
        add(newExpress);
    }

    public void delete(Express express){
        p: for (int i=0; i<10; i++){
            for (int j=0; j<10; j++){
                if (express.equals(data[i][j])){
                    data[i][j] = null;
                    break p;
                }
            }
        }
    }

    public Express[][] findAll(){
        return data;
    }


}
