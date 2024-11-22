package domain.ex3._1;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
@Table(name = "teams")
public class Team {

    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "team")
    private List<Player> players;
}
