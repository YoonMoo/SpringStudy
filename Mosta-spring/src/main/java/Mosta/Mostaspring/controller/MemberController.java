package Mosta.Mostaspring.controller;

import Mosta.Mostaspring.domain.Member;
import Mosta.Mostaspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
