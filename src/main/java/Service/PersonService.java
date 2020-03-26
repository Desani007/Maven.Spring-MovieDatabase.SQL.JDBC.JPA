package Service;

import io.zipcoder.persistenceapp.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.swing.text.html.Option;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class PersonService  {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource (DataSource myDataSource) {
        this.jdbcTemplate = new JdbcTemplate(myDataSource);
    }


    public void addPerson(Person person) {
        String sql = "INSERT INTO PERSON " +
                "( FIRST_NAME, LAST_NAME,MOBILE,BIRTHDAY,HOME_ID) VALUES ( ?, ?,?,?,?)";


        jdbcTemplate.update(sql, new Object[]{ person.getFirstName(),
                person.getLastName(), person.getMobileNumber(), person.getBirthDate(), person.getHomeId()});
    }

    public void  updatePerson (Person person){
        jdbcTemplate.update("Update PERSON set FIRST_NAME=?,LAST_NAME=?,MOBILE=?,BIRTHDAY=?,HOME_ID=? ",
                person.getFirstName(),person.getLastName(),person.getMobileNumber(),person.getBirthDate(),person.getHomeId());
    }

    public Person  findbyId (Long id){
       Person p= (Person) jdbcTemplate.queryForObject("Select * from Person where id=?",
                new Object[]{id}, new RowMapper(){
                 public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                       Person person = new Person();
                       person.setFirstName(resultSet.getString("FIRST_NAME"));
                       person.setLastName(resultSet.getString("LAST_NAME"));
                       person.setMobileNumber(resultSet.getString("MOBILE"));
                      person.setBirthDate(resultSet.getDate("BIRTHDAY"));
                      person.setHomeId(resultSet.getInt("HOME_ID"));
                      return person;
                 }
               });
        return p;
    }

}