package io.zipcoder.persistenceapp.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name="HOME")
public class Home {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonIgnore
    long id;
    @Column(name="ADDRESS")
    String address;
    @Column(name="HOMENUMBER")
    String homeNumber;
    @Column(name="HOMENUMBER")

    @OneToMany(cascade=CascadeType.ALL)
    List<Person> personList;

    public Home() {

    }

    public Home(String address, String homeNumber, Person personList) {
        this.address = address;
        this.homeNumber = homeNumber;
       this.personList= Stream.of(personList).collect(Collectors.toList());
      this.personList.forEach(x -> x.setHome(this));

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
