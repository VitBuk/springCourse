package com.vitbuk.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam("name") String name,
                            @RequestParam("surname") String surname,
                            Model model) {
        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatePage(@RequestParam("a") int a,
                                @RequestParam("b") int b,
                                @RequestParam("action") String action,
                                Model model){
        String answer = "Result is: ";
        System.out.println("Action: " + action);

        switch (action) {
            case "addition":
                answer += String.valueOf(a + b);
                break;
            case "subtraction":
                answer += String.valueOf(a - b);
                break;
            case "multiplication":
                answer += String.valueOf(a * b);
                break;
            case "division":
                answer += String.valueOf(a / b);
                break;
            default:
                answer = "There is no such operation, please use: addition, subtraction, multiplication or division ";
                break;
        }

        model.addAttribute("answer", answer);
        return "first/calculated";
    }


}
