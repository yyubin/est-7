package org.example.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/layouts/pages")
public class TemplateController3 {

    @GetMapping("/1")
    public String showPage1() {
        return "/components/page1";
    }

    @GetMapping("/2")
    public String showPage2() {
        return "/components/page2";
    }

    @GetMapping("/3")
    public String showPage3(Model model) {
        model.addAttribute("isLogin", true);
        return "/components/page3";
    }

    @GetMapping("/4")
    public String showPage4(Model model) {
        model.addAttribute("isLogin", true);
        model.addAttribute("post", new Post(1L, "hi", "i", "hey"));
        return "/components/page4";
    }


}
