package Mosta.Mostaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MostaController {

    @GetMapping("hello2") // html 주소
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // html 파일을 찾아간다.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
}
