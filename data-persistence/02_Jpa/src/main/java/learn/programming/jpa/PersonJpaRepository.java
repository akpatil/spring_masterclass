package learn.programming.jpa;

import learn.programming.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class PersonJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;
    /* Entity Manager is the interface and PersistenceContext is the implementation */

    public List<Person> findAll() {
        TypedQuery<Person> namedQuery = entityManager.createNamedQuery("findAllPersons", Person.class);
        return namedQuery.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public Person update(Person person) {
        return entityManager.merge(person);
        /* merge() method checks for id, if it exists then it updates the record otherwise it inserts the record */
    }

    public void deleteById(int id) {
        Person person = findById(id);
        entityManager.remove(person);
        log.info("Removed person {}", person);
    }
}
