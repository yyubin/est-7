package org.example.viewexp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Controller
public class FourthController {

    // REST API
    // /boards/공지사항/posts/1?mode=dark

    // 경로 변수(Path Variable)
    @ResponseBody
    @GetMapping("/path1/{name}")
    public String showPathVariable(@PathVariable(name = "name") String name) {
        System.out.println("FourthController.showPathVariable");
        System.out.println("name = " + name);
        return "";
    }

    @ResponseBody
    @GetMapping("/path1/test")
    public String showPathVariable2() {
        System.out.println("FourthController.showPathVariable2");
        return "";
    }

    @ResponseBody
    @GetMapping(value = {"/path2", "/path2/{name}"})
    public String showPathVariable3(
            @PathVariable(name = "name", required = false) String name
    ) {
        System.out.println("FourthController.showPathVariable3");
        System.out.println("name = " + name);
        return "";
    }

    @ResponseBody
    @GetMapping(value = {"/path3", "/path3/{name}"})
    public String showPathVariable4(
            @PathVariable(name = "name")Optional<String> nameOptional
            ) {
        System.out.println("FourthController.showPathVariable4");
        System.out.println("name = " + nameOptional.orElse(null));
        return "";
    }

    @ResponseBody
    @GetMapping("/path4/{name}")
    public String showPathVariable5(@PathVariable String name) {
        System.out.println("FourthController.showPathVariable5");
        System.out.println("name = " + name);
        return "";
    }

    @ResponseBody
    @GetMapping("/path5/{name}/{other}")
    public String showPathVariable6(@PathVariable String name, @PathVariable String other) {
        System.out.println("FourthController.showPathVariable6");
        System.out.println("name = " + name);
        System.out.println("other = " + other);
        return "";
    }

}
