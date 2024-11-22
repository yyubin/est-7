package org.example.demospring;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Chief {

    private CuisineAbility ability;

    public Chief(CuisineAbility ability) {
        this.ability = ability;
    }

    public void cook(List<String> ingredients) {
        ability.apply(ingredients);
    }

}
