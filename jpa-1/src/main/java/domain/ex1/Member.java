package domain.ex1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
public class Member {
    // 기본생성자
    // protected public
    @Id
    private String id;
    private String name;
}
