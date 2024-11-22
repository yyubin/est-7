package org.example.thymeleaf;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController1 {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/page1")
    public String page1(Model model) {
        model.addAttribute("message", "Hello Thymeleaf");
        return "page1";
    }

    @GetMapping("/page2")
    public String page2(Post post, Model model) {
        model.addAttribute("post", post);
        return "page2";
    }

    @Data
    class Post {
        private String title;
        private String content;
    }

    @GetMapping("/page3")
    public String page3(Model model) {
        String unsafe = "<script>alert('메롱');</script>";
        model.addAttribute("script", unsafe);
        return "page3";
    }

    @GetMapping("/page4")
    public String page4(Model model) {
        model.addAttribute("cellPhone", "mo");
        model.addAttribute("countryCallingCode", "82");
        return "page4";
    }

}
