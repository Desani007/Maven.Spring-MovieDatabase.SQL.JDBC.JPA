package io.zipcoder.persistenceapp.Service;

import io.zipcoder.persistenceapp.Model.Home;
import io.zipcoder.persistenceapp.Repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class HomeService {
    @Autowired
    private HomeRepository homeRepository;

    public void addHome(Home home){
        homeRepository.save(home);
    }



}
