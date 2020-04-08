package chapter3.day09;

public class Pack {
    String number;
    String company;
    public Pack(String number, String company){
        this.number = number;
        this.company = company;
    }

    public String getNumber() {
        return number;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Pack{" +
                "number='" + number + '\'' +
                ", company='" + company + '\'' +
                '}';
    }
}
