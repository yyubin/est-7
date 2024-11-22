package domain.ex3._1;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
@Table(name = "players")
public class Player {
    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JoinColumn(name = "team_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
}
