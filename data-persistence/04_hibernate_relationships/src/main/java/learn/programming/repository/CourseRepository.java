package learn.programming.repository;

import learn.programming.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    @Query("SELECT c FROM Course c WHERE name LIKE '%wild%'")
    List<Course> courseWithWildInIt();

    @Query(value = "SELECT * FROM COURSE c WHERE name LIKE '%wild%'", nativeQuery = true)
    List<Course> courseWithWildInItCustom();

    @Query(name = "all_courses")
    List<Course> allCoursesWithNamedQueries();
}
