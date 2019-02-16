package learn.programming.repository;

import learn.programming.entity.Passport;
import learn.programming.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {
    @Autowired
    private EntityManager manager;

    public void saveStudentWithPassport() {
        Passport passport = new Passport("W344560");
        manager.persist(passport);

        Student student = new Student("William Birkins");
        student.setPassport(passport);
        manager.persist(student);
    }
}
