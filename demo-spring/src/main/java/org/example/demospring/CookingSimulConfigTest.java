package org.example.demospring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.List;

public class CookingSimulConfigTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CookingSimulatorConfiguration.class);
        Chief chief = context.getBean(Chief.class);
        List<String> list = List.of("1", "2");
        chief.cook(list);
    }

}
