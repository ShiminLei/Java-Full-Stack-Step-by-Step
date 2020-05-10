package chapter4_core_library.day03_set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Remove_in_list {

    public static void main(String[] args) {
        //准备数据
        List<String> list = new ArrayList<>();
        list.add("male");
        list.add("female");
        list.add("female");
        list.add("male");

        //遍历删除,除去男生
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = iterator.next();
            if ("male".equals(str)) {
                iterator.remove();//使用迭代器的删除方法删除
            }
        }

        for (String str: list){
            System.out.println(str);
        }
    }
}
