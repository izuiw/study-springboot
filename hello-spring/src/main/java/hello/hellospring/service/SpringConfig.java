package hello.hellospring.service;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;
import javax.swing.text.html.parser.Entity;

@Configuration
public class SpringConfig {
    /*
        자바코드로 빈 설정하는 것의 장단점
           -현 예제에서는 아직 db가 정해지지 않는 것을 가정하고
           MemoryRepository를 변경 할 것.
           -이 때, 직접 빈 설정을 하면, config 파일 이외에는 건드리지 않아도 되는 장점이 있음

     */

//    private DataSource dataSource;
//    @PersistenceContext
//    private EntityManager em;

    private final MemberRepository memberRepository; //spring jpa가 만들어놓은 구현체가 등록됨
    @Autowired
    public SpringConfig(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop (){
//        return new TimeTraceAop();
//    }
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//
//    }

}
