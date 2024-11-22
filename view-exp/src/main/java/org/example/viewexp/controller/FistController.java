package org.example.viewexp.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class FistController {

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public void receiveRequestFromBrowser() {
        System.out.println("FistController.receiveRequestFromBrowser");
    }

    @GetMapping("/hello")
    public void printString() {
        System.out.println("FistController.printString");
    }

    @GetMapping("/hello2")
    public void printString2(HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("wtf");
    }

    @ResponseBody
    @GetMapping("/hello3")
    public String printString3() {
        return "hello3";
    }


    @ResponseBody
    @GetMapping("/hello4")
    public String[] printString4() {
        return new String[] {
                "hello4",
                "hello5",
        };
    }

    @ResponseBody
    @GetMapping("/hello5")
    public Any printString5() {
        return new Any();
    }

    @NoArgsConstructor
    @Data
    class Any {
        private final String data = "데이터";
    }
}
