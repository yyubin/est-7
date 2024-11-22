package org.example.viewexp.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class ThirdController {

    @ResponseBody
    @GetMapping("/params1")
    public String showParams1(HttpServletRequest request) {
        System.out.println("/params1");
        String name = request.getParameter("name");
        System.out.println("name = " + name);

        Map<String, String[]> parameterMap = request.getParameterMap();

        parameterMap.forEach((k, v) -> {
            System.out.println(k + " = " + Arrays.toString(v));
        });

        return "";
    }

    @ResponseBody
    @GetMapping("/params2")
    public String showParams2(@RequestParam(name = "name") String name) {
        System.out.println("ThirdController.showParams2");
        System.out.println(name);
        return "";
    }

    @ResponseBody
    @GetMapping("/params3")
    public String showParams3(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "age", required = false, defaultValue = "1") int age
    ) {
        System.out.println("ThirdController.showParams3");
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "";
    }

    @ResponseBody
    @GetMapping("/params4")
    public String showParams4(@ModelAttribute SingInInformation information) {
        System.out.println("ThirdController.showParams4");
        System.out.println("information.username = " + information.username);
        System.out.println("information.password = " + information.password);
        return "";
    }

    @Data
    class SingInInformation {
        private String username;
        private String password;
    }

    @ResponseBody
    @GetMapping("/params5")
    public String showParams5(SingInInformation information) {
        System.out.println("ThirdController.showParams5");
        System.out.println("information.username = " + information.getUsername());
        System.out.println("information.password = " + information.getPassword());
        return "";
    }
    
    @ResponseBody
    @GetMapping("/params6")
    public String showParams6(
            @RequestParam(name = "favorite") String[] favorites
    ) {
        System.out.println("ThirdController.showParams6");
        for (String favorite : favorites) {
            System.out.println("favorite = " + favorite);
        }
        return "";
    }

}
