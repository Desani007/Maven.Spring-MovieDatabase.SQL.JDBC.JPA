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
     PersonService personService;





    @PostMapping(value = "/people")
    public HttpStatus create(@RequestBody  Person person){
     personService.addPerson(person);
        return HttpStatus.OK;


    }

    @GetMapping(value="/people/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Person  findById(@PathVariable("id")  long id){
         return personService.findbyId(id);

    }

    @PutMapping(value="/people/{id}")
    public ResponseEntity  update(@PathVariable("id") long id, @RequestBody Person person){
       personService.updatePerson(id,person);
       return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping(value="/people/{id}")
    public ResponseEntity delete(@PathVariable("id") long id){
        personService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping(value ="/people")
    @ResponseBody
    public List<Person> findAll(){
        List<Person> list =personService.findAll();
        return  list;
    }

    @GetMapping(value="/people/reverselookup/{mobileNumber}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Person  findByNumber(@PathVariable("mobileNumber")  String mobileNumber){
        return personService.findByNumber(mobileNumber);


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
