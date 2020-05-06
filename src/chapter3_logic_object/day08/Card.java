package chapter3_logic_object.day08;

import java.util.Objects;
import java.util.Random;

public class Card {
    private final String cardId;
    private String password;
    private int money;
    private boolean isLock;

    public String getPassword() {
        return password;
    }

    public Card() {
        this.cardId = generateID();
        this.isLock = false;
        this.money = 0;
    }

    private String generateID(){
        String id = "";
        Random rd = new Random();
        for (int i=0; i<16; i++){
            id += rd.nextInt(10);
        }
        return id;
    }

    public String getCardId() {
        return cardId;
    }

    public int getMoney() {
        return money;
    }

    public boolean isLock() {
        return isLock;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getCardId().equals(card.getCardId());
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardId='" + cardId + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardId());
    }

    public void withDraw(int amount) {
        this.money -= amount;
    }

    public void deposit(int amount) {
        this.money += amount;
    }

    public void unlock() {
        isLock = false;
    }

    public void lock() {
        isLock = true;
    }
}
