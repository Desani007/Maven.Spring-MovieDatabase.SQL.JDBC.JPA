package io.zipcoder.persistenceapp.Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Home implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    long id;
    String address;
    String homeNumber;

    @OneToMany
    List<Person> personList;


    public Home() {

    }

    public Home(String address, String homeNumber, Person personList) {
        this.address = address;
        this.homeNumber = homeNumber;
        this.personList= Stream.of(personList).collect(Collectors.toList());
        this.personList.forEach(x -> x.setHomeId(this));

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

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> list) {
        this.personList = list;
    }
}
