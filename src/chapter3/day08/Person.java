package chapter3.day08;

import java.util.Objects;

public class Person {
    private String name;
    private final String userId;
    private String phone;
    private Card card;

    public Person(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", userId='" + userId + '\'' +
                ", phone='" + phone + '\'' +
                ", card=" + card +
                '}';
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return userId.equals(person.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }
}
