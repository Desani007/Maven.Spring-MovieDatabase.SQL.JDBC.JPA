package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.Model.Person;
import Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Controller
public class PersonController {
    @Autowired
     PersonService personService ;




    @PostMapping(value = "/people")
    public String create(@RequestParam ("fname") String firstName,
                         @RequestParam ("lname")String lastName,
                         @RequestParam ("number") String mobileNumber,
                         @DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("date") Date birthDate,
                         @RequestParam ("id") int homeId) {


        Person person = new Person();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setMobileNumber(mobileNumber);
        person.setBirthDate(birthDate);
        person.setHomeId(homeId);
     personService.addPerson(person);
        return "success";


    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public void findById(@RequestParam("id") long id){
         personService.findbyId(id);

    }

    @RequestMapping(value = "/hello",method = RequestMethod.GET )
    @ResponseBody
    public String  helloWorld(){
        return "damn just say hello";

    }
}
