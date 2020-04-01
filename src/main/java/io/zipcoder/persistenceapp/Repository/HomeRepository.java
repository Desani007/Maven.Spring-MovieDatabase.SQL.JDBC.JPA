package io.zipcoder.persistenceapp.Repository;

import io.zipcoder.persistenceapp.Model.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface HomeRepository extends JpaRepository<Home,Long > {
}
