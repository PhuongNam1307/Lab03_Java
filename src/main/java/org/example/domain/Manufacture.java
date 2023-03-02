package org.example.domain;

import javax.persistence.*;

import lombok.Data;
import org.example.domain.*;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "Manufacture")
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String manufactureID;
    @Column
    private String name;
    @Column
    private String location;
    @Column
    private int employee;

    @OneToMany(mappedBy = "manufacture", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Phone> phoneList = new ArrayList<>();


    public Manufacture(String id, String name, String location, int employee) {
        this.manufactureID = id;
        this.name = name;
        this.location = location;
        this.employee = employee;
    }


    public String getId() {
        return manufactureID;
    }

    public void setId(String id) {
        this.manufactureID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Manufacture[" +
                "id='" + manufactureID + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", employee=" + employee +
                ']';
    }
}
