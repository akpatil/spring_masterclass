package learn.programming.entity;

import javax.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String number;

    /* mappedBy is used to allow non-owning side of the relationship to access the data of the owning side.
     * In this example, Student is the owning side and passport is the non-owning side.
      * the value in the mappedBy attribute is the property name from the owning side of the class. */
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student;

    public Passport() {}

    public Passport(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "\n Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
