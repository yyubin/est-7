package org.example.demospring;

import lombok.Getter;

import java.util.List;

public class FranceCuisineAbility extends CuisineAbility {

    @Getter
    private int exp = 0;

    private void increaseExp() {
        exp++;
    }

    public void apply(List<String> ingredients) {
        increaseExp();
        String used = String.join(" ", ingredients);
        System.out.println(used + "을(를) 사용해서 프랑스 요리를 만들었습니다!");
    }

}
