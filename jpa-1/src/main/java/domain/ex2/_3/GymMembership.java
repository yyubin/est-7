package domain.ex2._3;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class GymMembership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Enumerated(EnumType.ORDINAL)
    @Enumerated(EnumType.STRING)
    private Level membershipLevel;
}
