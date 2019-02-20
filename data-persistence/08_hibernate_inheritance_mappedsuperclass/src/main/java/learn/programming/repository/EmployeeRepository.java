package learn.programming.repository;

import learn.programming.entity.Employee;
import learn.programming.entity.FullTimeEmployee;
import learn.programming.entity.PartTimeEmployee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Slf4j
@Repository
@Transactional
public class EmployeeRepository {
    @Autowired
    private EntityManager em;

    public void insertEmployee(Employee e) {
        em.persist(e);
    }

    public List<PartTimeEmployee> getPartTimeEmployees() {
        return em.createQuery("SELECT e FROM PartTimeEmployee e", PartTimeEmployee.class).getResultList();
    }

    public List<FullTimeEmployee> getFullTimeEmployees() {
        return em.createQuery("SELECT e FROM FullTimeEmployee e", FullTimeEmployee.class).getResultList();
    }

}
