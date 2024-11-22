package domain.ex3._2;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "owners")
public class Owner {
    @Id
    @Column(name = "owners_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "locker_id")
    private Locker locker;
    private String name;
}
