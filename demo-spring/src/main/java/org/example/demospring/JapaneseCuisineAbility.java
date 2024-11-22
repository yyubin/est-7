package org.example.demospring;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JapaneseCuisineAbility extends CuisineAbility {

    @Getter
    private int exp = 0;

    private void increaseExp() {
        exp++;
    }

    public void apply(List<String> ingredients) {
        increaseExp();
        String used = String.join(" ", ingredients);
        System.out.println(used + "을(를) 볶아서 일본 요리를 만들었습니다!");
    }

}
