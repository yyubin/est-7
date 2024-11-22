package org.example.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/page")
public class TemplateController2 {

    @GetMapping("/1")
    public String syntaxPage1(String username, Model model) {
        model.addAttribute("username", username);
        return "/syntax/page1";
    }

    @GetMapping("/2")
    public String syntaxPage2(Model model) {
        List<String> list = Arrays.asList("이클립스", "몬스터");
        model.addAttribute("shoppingList", list);
        return "/syntax/page2";
    }

    @GetMapping("/3")
    public String syntaxPage3(Model model) {
        Post post = new Post(1L, "hi", "me", "hey");
        model.addAttribute("post", post);
        return "/syntax/page3";
    }


    @GetMapping("/4-1")
    public String syntaxPage4_1(Model model) {
        model.addAttribute("post", new Post());
        return "/syntax/page4-1";
    }

    @PostMapping("/4")
    public String doSyntaxPage(Post post, Model model) {
        System.out.println(post.toString());
        return "/syntax/page4-1";
    }

    @GetMapping("/5")
    public String syntaxPage5() {
        return "/syntax/page5";
    }

    @GetMapping("/6")
    public String syntaxPage6(int target, Model model) {
        model.addAttribute("target", target);
        return "/syntax/page6";
    }



}
