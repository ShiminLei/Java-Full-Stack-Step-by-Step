package chapter3_logic_object.day09.kuaidi.bean;

import java.io.Serializable;
import java.util.Objects;

public class Express implements Serializable {
    // 单号
    private String number;
    // 公司
    private String company;
    // 取件码
    private int code;

    public Express() {
    }

    public Express(String number, String company, int code) {
        this.number = number;
        this.company = company;
        this.code = code;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "快递信息：{" +
                "快递单号：'" + number + '\'' +
                ", 快递公司：'" + company + '\'' +
                ", 取件码：" + code +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Express)) return false;
        Express express = (Express) o;
        return getNumber().equals(express.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
