package learn.programming.dao;

import learn.programming.entity.Person;
import learn.programming.mapper.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> findAll() {
        return jdbcTemplate.query("SELECT * FROM PERSON", new BeanPropertyRowMapper<>(Person.class));
    }

    public List<Person> findAllByCustomMapper() {
        return jdbcTemplate.query("SELECT * FROM PERSON", new PersonRowMapper());
    }

    public Person findById(int id) {
        return jdbcTemplate.queryForObject(
                "select * from person where id = ?",
                new Object[]{id},
                new BeanPropertyRowMapper<Person>(Person.class));
    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id = ?", new Object[] {id});
    }

    public int insert(Person p) {
        return jdbcTemplate.update(
                "insert into person (id, name, location, birth_date) values(?, ?, ?, ?)",
                new Object[] {p.getId(), p.getName(), p.getLocation(), new Timestamp(p.getBirthDate().getTime())});
    }

    public int update(Person p) {
        return jdbcTemplate.update(
                "update person set name = ?, location = ?, birth_date = ? where id = ?",
                new Object[] {p.getName(), p.getLocation(), new Timestamp(p.getBirthDate().getTime()), p.getId()});
    }

}
