package chapter3.day08;

import java.util.*;

public class ATM {
    private Set<Person> persons;
    private Set<Card> cards;
    private Map<String, Person> cardIdToPerson;
    private Views views;
    private Controller controller;
    private Map<String, Person> userIdToPerson;

    public ATM() {
        this.persons = new HashSet<>();
        this.cards = new HashSet<>();
        this.cardIdToPerson = new HashMap<>();
        this.userIdToPerson = new HashMap<>();
        this.views = new Views();
        this.controller = new Controller(this);
    }

    public Set<Person> getPersons() {
        return persons;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public Map<String, Person> getCardIdToPerson() {
        return cardIdToPerson;
    }

    public Map<String, Person> getUserIdToPerson() {
        return userIdToPerson;
    }

    public void start(){
        views.welcome();
        boolean on = true;
        while (on){
            views.menu();
            int operation;
            Scanner sc = new Scanner(System.in);
            try{
                operation = sc.nextInt();
                sc.nextLine();
                if (operation<1 || operation>10){
                    System.out.println("请重新输入1-10的数字。");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("输入格式有误，请重新输入。");
                continue;
            }
            if (operation==1){
                controller.register();
            }else if (operation==2){
                controller.query();
            }else if (operation==3){
                controller.getMoney();
            }else if (operation==4){
                controller.addMoney();
            }else if (operation==5){
                controller.saveMoney();
            }else if (operation==6){
                controller.lock();
            }else if (operation==7){
                controller.unlock();
            }else if (operation==8){
                controller.newCard();
            }else if (operation==9){
                controller.changePwd();
            }else {
                controller.save();
                on = false;
            }
        }
    }


}
