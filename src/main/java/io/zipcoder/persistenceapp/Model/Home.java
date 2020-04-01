package io.zipcoder.persistenceapp.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Home {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;
    String address;
    String homeNumber;
    @OneToMany
    List<Person> list;


    public Home() {

    }

    public Home(String address, String homeNumber) {
        this.address = address;
        this.homeNumber = homeNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
}
