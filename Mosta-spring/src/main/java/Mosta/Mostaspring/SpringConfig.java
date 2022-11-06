package Mosta.Mostaspring;

import Mosta.Mostaspring.repository.MemberRepository;
import Mosta.Mostaspring.repository.MemoryMemberRepository;
import Mosta.Mostaspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
