package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.Model.Home;
import io.zipcoder.persistenceapp.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService=homeService;
    }

    @PostMapping(value = "/home/")
    public ResponseEntity<Home> create(@RequestBody Home home){
        return  new ResponseEntity<Home>(homeService.addHome(home), HttpStatus.CREATED);

}

    @GetMapping(value = "/home/{id}")
    public ResponseEntity<Home> findbyId(@RequestParam long id){
        return  new ResponseEntity<Home>(homeService.findByid(id), HttpStatus.OK);

    }

    @GetMapping(value = "/findhome/{homenumber}")
    public ResponseEntity<Home> findbyNumber(@RequestParam String  homenumber){
        return  new ResponseEntity<Home>(homeService.findByNumber(homenumber), HttpStatus.OK);

    }

    @GetMapping(value = "/findhome/{address}")
    public ResponseEntity<Home> findbyAddress(@RequestParam String  address){
        return  new ResponseEntity<Home>(homeService.findByNumber(address), HttpStatus.OK);

    }








}
