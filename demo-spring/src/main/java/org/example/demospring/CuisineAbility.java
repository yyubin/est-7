package org.example.demospring;

import java.util.List;

public abstract class CuisineAbility {

    private int exp = 0;
    private void increase() {
        exp++;
    }

    public abstract void apply(List<String> ingredients);

}
