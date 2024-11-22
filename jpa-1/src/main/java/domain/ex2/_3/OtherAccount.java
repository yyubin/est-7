package domain.ex2._3;

import jakarta.persistence.*;

@Entity
@Table(name = "other_account")
@TableGenerator(
        name = "other_account_table_generator",
        table = "other_account_sequence",
        pkColumnName = "account_seq", allocationSize = 1
)
public class OtherAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "other_account_table_generator")
    private Long id;
}
