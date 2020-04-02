package io.zipcoder.persistenceapp.Model;

import java.util.Date;


public class Person {

   private Long id;
    String firstName;
    @Column(name="LAST_NAME")
    String lastName;
    @Column(name="MOBILE")
    String mobileNumber;
    @Column(name="BIRTHDAY")
    Date birthDate;

    @ManyToOne(cascade=CascadeType.ALL)
    Home home;


    public Person(Long id, String firstName, String lastName, String mobileNumber, Date birthDate, Home homeId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.birthDate = birthDate;
        this.home =homeId;

    }

    public Person() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }
}
