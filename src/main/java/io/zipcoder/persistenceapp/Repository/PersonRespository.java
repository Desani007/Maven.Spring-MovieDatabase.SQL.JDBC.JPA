package io.zipcoder.persistenceapp.Repository;

import io.zipcoder.persistenceapp.Model.Home;
import io.zipcoder.persistenceapp.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRespository extends JpaRepository<Person,Long> {
}
