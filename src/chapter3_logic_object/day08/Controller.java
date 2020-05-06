package chapter3_logic_object.day08;

import java.util.Scanner;

public class Controller {
    private ATM atm;
    private static Scanner sc;

    public Controller(ATM atm) {
        this.atm = atm;
        this.sc = new Scanner(System.in);
    }

    /**
     * 1-注册
     */
    public void register(){
        // 生成用户
        System.out.println("请输入你的18位身份证ID：");
        String userId = sc.nextLine();
        if (userId.length()!=18){
            System.out.println("身份证号不合法！返回主菜单。");
            return;
        }
        Person person = new Person(userId);
        if (atm.getPersons().contains(person)){
            System.out.println("该用户已经存在！不要重复注册！返回主菜单。");
            return;
        }
        atm.getPersons().add(person);
        System.out.println("请输入你的用户名：");
        String name = sc.nextLine();
        person.setName(name);
        System.out.println("请输入你的电话号码 ：");
        String phone = sc.nextLine();
        person.setPhone(phone);
        System.out.println("成功注册用户。");

        Card card = createNewCard(atm);

        // 添加卡号到用户的映射
        person.setCard(card);
        atm.getCards().add(card);
        atm.getCardIdToPerson().put(card.getCardId(), person);
        atm.getUserIdToPerson().put(person.getUserId(), person);

        System.out.println("注册完毕！");
    }

    private static Card createNewCard(ATM atm){
        // 生成卡
        Card card = new Card();
        while (atm.getCards().contains(card)){
            card = new Card();
        }
        System.out.println("已经为您生成一张新卡。");
        System.out.println("卡号是 "+card.getCardId()+", 请您牢记该号码。");

        // 生成卡的密码
        while (true){
            System.out.println("请输入该卡的6位密码：");
            String password = sc.nextLine();
            if (password.length()!=6){
                System.out.println("您输入的不是6位密码，请重新输入。");
                continue;
            }
            System.out.println("请再次输入该卡的密码：");
            String password2 = sc.nextLine();
            if (password.equals(password2)){
                card.setPassword(password);
                System.out.println("设置密码完毕。");
                break;
            }else {
                System.out.println("两次密码不一样，请重新输入。");
            }
        }
        return card;
    }
    /**
     * 2-查询
     */
    public void query(){
        System.out.println("请输入卡号：");
        String cardId = sc.nextLine();
        if (!atm.getCardIdToPerson().containsKey(cardId)){
            System.out.println("该卡号不存在！返回主界面。");
            return;
        }
        Card card = atm.getCardIdToPerson().get(cardId).getCard();
        if (card.isLock()){
            System.out.println("该卡锁住了，请返回主菜单用身份证号码解锁。");
            return;
        }
        System.out.println("即将输入该卡的密码，您只有三次机会, 否则卡将会被锁住：");
        int count = 0;
        while (count<3){
            System.out.println("请输入密码：");
            String password = sc.nextLine();
             if (card.getPassword().equals(password)){
                 System.out.println("该卡的余额是：" + card.getMoney());
                 System.out.println("返回主界面。");
                 return;
             }else {
                 System.out.println("密码不正确。");
             }
             count++;
        }
        System.out.println("三次密码都输错了，卡锁定，返回主界面");
        card.lock();
    }

    /**
     * 3-取款
     */
    public void getMoney(){
        System.out.println("请输入卡号：");
        String cardId = sc.nextLine();
        if (!atm.getCardIdToPerson().containsKey(cardId)){
            System.out.println("该卡号不存在！返回主界面。");
            return;
        }
        Card card = atm.getCardIdToPerson().get(cardId).getCard();
        if (card.isLock()){
            System.out.println("该卡锁住了，请返回主菜单用身份证号码解锁。");
            return;
        }
        System.out.println("即将输入该卡的密码，您只有三次机会, 否则卡将会被锁住。");
        int count = 0;
        while (count<3){
            System.out.println("请输入密码：");
            String password = sc.nextLine();
            if (card.getPassword().equals(password)){
                System.out.println("该卡的余额是：" + card.getMoney());
                while (true){
                    System.out.println("请输入您需要取款的额度：");
                    int amount;
                    try{
                        amount = sc.nextInt();
                        sc.nextLine();
                    }catch (Exception e){
                        System.out.println("输入的数字不合法。");
                        continue;
                    }
                    if (amount>card.getMoney()||amount<0){
                        System.out.println("取款的额度不合法，请重新输入。");
                        continue;
                    }else{
                        card.withDraw(amount);
                        System.out.println("您取走了"+amount+", 该卡的余额是：" + card.getMoney());
                        break;
                    }
                }
                System.out.println("返回主界面。");
                return;
            }else {
                System.out.println("密码不正确。");
            }
            count++;
        }
        System.out.println("三次密码都输错了，卡锁定，返回主界面");
        card.lock();
    }

    /**
     * 4-存款
     */
    public void addMoney(){
        System.out.println("请输入卡号：");
        String cardId = sc.nextLine();
        if (!atm.getCardIdToPerson().containsKey(cardId)){
            System.out.println("该卡号不存在！返回主界面。");
            return;
        }
        Card card = atm.getCardIdToPerson().get(cardId).getCard();
        if (card.isLock()){
            System.out.println("该卡锁住了，请返回主菜单用身份证号码解锁。");
            return;
        }
        System.out.println("即将输入该卡的密码，您只有三次机会, 否则卡将会被锁住。");
        int count = 0;
        while (count<3){
            System.out.println("请输入密码：");
            String password = sc.nextLine();
            if (card.getPassword().equals(password)){
                System.out.println("该卡的余额是：" + card.getMoney());
                while (true){
                    System.out.println("请输入您需要存款的额度：");
                    int amount;
                    try{
                        amount = sc.nextInt();
                        sc.nextLine();
                    }catch (Exception e){
                        System.out.println("输入的数字不合法。");
                        continue;
                    }
                    if (amount<0){
                        System.out.println("取款的额度不合法，请重新输入。");
                        continue;
                    }else{
                        card.deposit(amount);
                        System.out.println("您存储了"+amount+", 该卡的余额是：" + card.getMoney());
                        break;
                    }
                }
                System.out.println("返回主界面。");
                return;
            }else {
                System.out.println("密码不正确。");
            }
            count++;
        }
        System.out.println("三次密码都输错了，卡锁定，返回主界面");
        card.lock();
    }

    /**
     * 5-转账
     */
    public void saveMoney(){
        // 本卡
        System.out.println("请输入卡号：");
        String cardId = sc.nextLine();
        if (!atm.getCardIdToPerson().containsKey(cardId)){
            System.out.println("该卡号不存在！返回主界面。");
            return;
        }
        Card card = atm.getCardIdToPerson().get(cardId).getCard();
        if (card.isLock()){
            System.out.println("该卡锁住了，请返回主菜单用身份证号码解锁。");
            return;
        }
        // 目标卡
        System.out.println("请输入转账目标账户的ID：");
        String cardId2 = sc.nextLine();
        if (!atm.getCardIdToPerson().containsKey(cardId2)){
            System.out.println("该卡号不存在！返回主界面。");
            return;
        }
        Card card2 = atm.getCardIdToPerson().get(cardId2).getCard();
        if (card2.isLock()){
            System.out.println("该卡锁住了，不能转账。");
            return;
        }

        // 输入密码
        System.out.println("即将输入该卡的密码，您只有三次机会, 否则卡将会被锁住。");
        int count = 0;
        while (count<3){
            System.out.println("请输入密码：");
            String password = sc.nextLine();
            if (card.getPassword().equals(password)){
                System.out.println("该卡的余额是：" + card.getMoney());
                while (true){
                    System.out.println("请输入您需要转账的额度：");
                    int amount;
                    try{
                        amount = sc.nextInt();
                        sc.nextLine();
                    }catch (Exception e){
                        System.out.println("输入的数字不合法。");
                        continue;
                    }
                    if (amount>card.getMoney()||amount<0){
                        System.out.println("转账的额度不合法，请重新输入。");
                        continue;
                    }else{
                        card.withDraw(amount);
                        card2.deposit(amount);
                        System.out.println("您转账了"+amount+", 该卡的余额是：" + card.getMoney());
                        break;
                    }
                }
                System.out.println("返回主界面。");
                return;
            }else {
                System.out.println("密码不正确。");
            }
            count++;
        }
        System.out.println("三次密码都输错了，卡锁定，返回主界面");
        card.lock();

    }

    /**
     * 6-锁卡
     */
    public void lock(){
        System.out.println("请输入卡号：");
        String cardId = sc.nextLine();
        if (!atm.getCardIdToPerson().containsKey(cardId)){
            System.out.println("该卡号不存在！返回主界面。");
            return;
        }
        Card card = atm.getCardIdToPerson().get(cardId).getCard();
        Person person = atm.getCardIdToPerson().get(cardId);

        System.out.println("请选择对应操作编号： 1.用密码锁卡 2.用身份证号锁卡");
        int choice;
        try{
            choice = sc.nextInt();
            sc.nextLine();
        }catch (Exception e){
            System.out.println("无此操作，返回主菜单。");
            return;
        }
        if (choice==1){
            System.out.println("请输入密码：");
            String password = sc.nextLine();
            if (card.getPassword().equals(password)){
                card.lock();
                System.out.println("锁卡成功。");
            }else {
                System.out.println("密码不正确, 返回主菜单。");
            }
        }else if (choice==2){
            System.out.println("请输入身份证号码：");
            String userId = sc.nextLine();
            if (person.getUserId().equals(userId)){
                card.lock();
                System.out.println("锁卡成功。");
            }else {
                System.out.println("身份证号码不正确, 返回主菜单。");
            }
        }else {
            System.out.println("无此操作，返回主菜单。");
        }
    }

    /**
     * 7-解卡
     */
    public void unlock(){
        System.out.println("请输入卡号：");
        String cardId = sc.nextLine();
        if (!atm.getCardIdToPerson().containsKey(cardId)){
            System.out.println("该卡号不存在！返回主界面。");
            return;
        }
        Card card = atm.getCardIdToPerson().get(cardId).getCard();
        Person person = atm.getCardIdToPerson().get(cardId);

        System.out.println("请输入身份证号码：");
        String userId = sc.nextLine();
        if (person.getUserId().equals(userId)){
            card.unlock();
            System.out.println("解卡成功。");
        }else {
            System.out.println("身份证号码不正确, 返回主菜单。");
        }
    }

    /**
     * 8-补卡
     */
    public void newCard(){
        System.out.println("请输入身份证号码：");
        String userId = sc.nextLine();
        if (!atm.getUserIdToPerson().containsKey(userId)){
            System.out.println("该用户不存在！返回主界面。");
            return;
        }
        Person person = atm.getUserIdToPerson().get(userId);
        Card oldCard = person.getCard();
        atm.getCards().remove(oldCard);
        atm.getCardIdToPerson().remove(oldCard.getCardId());
        person.setCard(null);

        Card newCard = createNewCard(atm);
        atm.getCards().add(newCard);
        atm.getCardIdToPerson().put(newCard.getCardId(), person);
        person.setCard(newCard);
        System.out.println("补卡完毕。");
    }

    /**
     * 9-改密
     */
    public void changePwd(){
        System.out.println("请输入卡号：");
        String cardId = sc.nextLine();
        if (!atm.getCardIdToPerson().containsKey(cardId)){
            System.out.println("该卡号不存在！返回主界面。");
            return;
        }
        Card card = atm.getCardIdToPerson().get(cardId).getCard();
        Person person = atm.getCardIdToPerson().get(cardId);

        System.out.println("请选择对应操作编号： 1.用原密码改密 2.用身份证号改密");
        int choice;
        try{
            choice = sc.nextInt();
            sc.nextLine();
        }catch (Exception e){
            System.out.println("无此操作，返回主菜单。");
            return;
        }
        if (choice==1){
            System.out.println("请输入密码：");
            String password = sc.nextLine();
            if (card.getPassword().equals(password)){
                while (true){
                    System.out.println("请输入该卡的6位密码：");
                    String newpassword = sc.nextLine();
                    if (newpassword.length()!=6){
                        System.out.println("您输入的不是6位密码，请重新输入。");
                        continue;
                    }else {
                        card.setPassword(newpassword);
                        System.out.println("修改密码成功。");
                        break;
                    }
                }
            }else {
                System.out.println("密码不正确, 返回主菜单。");
            }
        }else if (choice==2){
            System.out.println("请输入身份证号码：");
            String userId = sc.nextLine();
            if (person.getUserId().equals(userId)){
                while (true){
                    System.out.println("请输入该卡的6位密码：");
                    String newpassword = sc.nextLine();
                    if (newpassword.length()!=6){
                        System.out.println("您输入的不是6位密码，请重新输入。");
                        continue;
                    }else {
                        card.setPassword(newpassword);
                        System.out.println("修改密码成功。");
                        break;
                    }
                }
            }else {
                System.out.println("身份证号码不正确, 返回主菜单。");
            }
        }else {
            System.out.println("无此操作，返回主菜单。");
        }

    }

    /**
     * 10-退出
     */
    public void save(){

    }
}
