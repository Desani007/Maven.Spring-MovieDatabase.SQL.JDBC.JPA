package io.zipcoder.persistenceapp.Service;

import io.zipcoder.persistenceapp.Model.Home;
import io.zipcoder.persistenceapp.Model.Person;
import io.zipcoder.persistenceapp.Repository.HomeRepository;
import io.zipcoder.persistenceapp.Repository.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.Optional;

@Service
public class HomeService {
    @Autowired
    private HomeRepository homeRepository;

    @Autowired
    private PersonRespository personRespository;

    public Home addHome(Home home){
        return homeRepository.save(home);
    }

    public Home findByid(long id){
       return homeRepository.findOne(id);
    }

    public Home findByNumber(String homeNumber){
        return homeRepository.findByHomeNumber(homeNumber);
    }

    public Home findbyAdress(String address){
        return homeRepository.findByAddress(address);
    }

  /*  public Person findPersonbyhome(Home  home){

        return personRespository.findPersonByHome(home);
    }
    */




}
