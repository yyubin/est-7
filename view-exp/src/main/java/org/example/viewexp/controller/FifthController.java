package org.example.viewexp.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.example.viewexp.service.SuperComplexService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class FifthController {
    private final SuperComplexService superComplexService;

    @ResponseBody
    @GetMapping("/sum")
    public String showResult(Number number) {
        System.out.println(superComplexService.sum(number));
        return "";
    }

    @Data
    public class Number {
        int a;
        int b;
    }

}
