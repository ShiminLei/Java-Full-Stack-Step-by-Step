package chapter3.day06;

public class Car {
    private String brand;
    private String color;

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public void show(){
        System.out.println("品牌是"+this.brand);
        System.out.println("颜色是"+this.color);
    }
}
