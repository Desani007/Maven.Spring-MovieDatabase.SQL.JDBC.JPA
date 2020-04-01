package io.zipcoder.persistenceapp.Controller;

import io.zipcoder.persistenceapp.Model.Home;
import io.zipcoder.persistenceapp.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    @Autowired
    HomeService homeService;


@PostMapping("/home")
    public  void create(@RequestBody Home home){
    homeService.addHome(home);
}








}
