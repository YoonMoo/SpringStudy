package Mosta.Mostaspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MostaController {

    @GetMapping("hello2") // html 주소
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        return "hello"; // html 파일을 찾아간다.
    }
}
