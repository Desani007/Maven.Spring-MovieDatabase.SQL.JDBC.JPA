package io.zipcoder.persistenceapp.Repository;

import io.zipcoder.persistenceapp.Model.Home;
import io.zipcoder.persistenceapp.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface HomeRepository extends CrudRepository<Home,Long> {
    public Home findByHomeNumber(String homeNumber);
    public Home findByAddress(String address);
    Home findHomeByPersonList(long id);
}

