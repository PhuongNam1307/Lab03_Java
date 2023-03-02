package org.example.domain;

import javax.persistence.*;
import org.example.domain.*;

import lombok.Data;
@Data
@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String phoneID;

    @Column
    private String name;
    @Column
    private int price;
    @Column
    private String color;
    @Column
    private String country;
    @Column
    private int qty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacture_id")
    private Manufacture manufacture;

    public Phone(String id, String name, int price, String color, String country, int qty, Manufacture manufacture) {
        this.phoneID = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.country = country;
        this.qty = qty;
        this.manufacture = manufacture;
    }

    public String getPhoneID() {
        return phoneID;
    }

    public void setId(String id) {
        this.phoneID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Phone[" +
                "id='" + phoneID + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", country='" + country + '\'' +
                ", qty=" + qty +
                ']';
    }
}
