package domain.ex2._1;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "article")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title; // string은 varchar있으면 varchar, 없으면 varchar2

    @Column(name = "contents", columnDefinition = "TEXT")
    private String contents;

    @Builder
    public Post(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
