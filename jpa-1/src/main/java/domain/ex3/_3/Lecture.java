package domain.ex3._3;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @ManyToMany
    @JoinTable(
            name = "student_lecture",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id")
    )
    private List<Student> students;
}
