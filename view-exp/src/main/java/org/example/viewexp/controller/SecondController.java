package org.example.viewexp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

    @GetMapping("/page1")
    public String page1() {
        return "page1";
    }
}
