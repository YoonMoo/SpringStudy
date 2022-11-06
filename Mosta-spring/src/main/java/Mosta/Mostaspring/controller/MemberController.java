package Mosta.Mostaspring.controller;

import Mosta.Mostaspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    //private final MemberService memberService = new MemberService();
    // 여러곳에서 멤버 서비스를 사용하므로 new로 생성하는 것은 부적절

    // 스프링 컨테이너에 등록을 하고 사용하는 방법
    private final MemberService memberService;

    // 생성자에 autowired
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }
}
