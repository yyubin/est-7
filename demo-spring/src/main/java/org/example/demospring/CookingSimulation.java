package org.example.demospring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class CookingSimulation {

    public static void main(String[] args) {
//        GameConfiguration gameConfiguration = new GameConfiguration();
//        Chief chief = gameConfiguration.chief();
//        List<String> ingredients = Arrays.asList("치즈", "파스타면", "달걀", "바지락");
//        chief.cook(ingredients);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(GameConfiguration.class);

        List<String> ingredients = Arrays.asList("가쓰오부시", "문어", "마요네즈");
        Chief chief = context.getBean("chief", Chief.class);
        chief.cook(ingredients);
        chief.cook(ingredients);

        Chief chief2 = context.getBean("chief", Chief.class);
        chief2.cook(ingredients);

        JapaneseCuisineAbility ability = context.getBean("japaneseCuisineAbility", JapaneseCuisineAbility.class);
        System.out.println(ability.getExp());
    }
}
