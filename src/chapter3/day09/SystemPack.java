package chapter3.day09;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SystemPack {
    Map<String, Pack> numToPack;
    Map<String, Box> numToBox;

    public SystemPack() {
        this.numToPack = new HashMap<>();
        this.numToBox = new HashMap<>();
    }

    public void seeAllPack(){
        for (String num: numToPack.keySet()){
            System.out.println(numToPack.get(num));
        }
    }

    public void modifyPack(String takeNum,Pack newPack){
        numToPack.put(takeNum, newPack);
    }

    public void deletePack(String takeNum){
        numToBox.remove(takeNum);
        numToPack.remove(takeNum);
    }

    public Pack pollPack(String takeNum){
        Pack pack = numToPack.get(takeNum);
        Box box = numToBox.get(takeNum);
        deletePack(takeNum);
        System.out.println(pack);
        System.out.println(box);
        return pack;
    }

    public void offerPack(Pack pack){
        String takeNum = generateTakeNum();
        Box box = new Box();
        numToPack.put(takeNum, pack);
        numToBox.put(takeNum, box);
    }

    private String generateTakeNum(){
        Random rd = new Random();
        String takeNum = "";
        for (int i=0; i<10; i++){
            takeNum += rd.nextInt(10);
        }
        return takeNum;
    }
}
