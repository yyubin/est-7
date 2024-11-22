package domain.ex2._3;

import jakarta.persistence.*;

@Entity
@SequenceGenerator(
        name = "custom_sequence_generator",
        sequenceName = "account_seq",
        initialValue = 1, allocationSize = 1
)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custom_sequence_generator")
    private Long id;

    private String name;


}
