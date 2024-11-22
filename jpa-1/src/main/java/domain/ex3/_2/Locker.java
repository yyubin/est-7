package domain.ex3._2;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Locker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne(mappedBy = "Locker")
    private Owner owner;
}
