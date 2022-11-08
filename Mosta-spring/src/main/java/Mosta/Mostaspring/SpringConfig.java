package Mosta.Mostaspring;

import Mosta.Mostaspring.repository.JdbcTemplateMemberRepository;
import Mosta.Mostaspring.repository.MemberRepository;
import Mosta.Mostaspring.repository.MemoryMemberRepository;
import Mosta.Mostaspring.repository.jdbcMemberRepository;
import Mosta.Mostaspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import javax.xml.crypto.Data;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){

        //return new MemoryMemberRepository();
        //return new jdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
