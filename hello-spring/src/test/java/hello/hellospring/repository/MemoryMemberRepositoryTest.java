package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {



    MemoryMemberRepository repository = new MemoryMemberRepository();

    //test 끝날 때마다 메모리를 지워주는 메서드
    @AfterEach
    public void afterEach(){
        repository.clearStore();
        //test 메서드가 서로 순서에 영향을 받지 않아야함.
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("izuiw");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
       // Assertions.assertEquals(member,result);
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member memberone = new Member();
        memberone.setName("izuiw1");
        repository.save(memberone);

        Member membertwo = new Member();
        membertwo.setName("izuiw2");
        repository.save(membertwo);

       Member result =  repository.findByName("izuiw1").get();

       Assertions.assertThat(result).isEqualTo(memberone);
    }


    @Test
    public void findAll() {

        Member memberone = new Member();
        memberone.setName("izuiw1");
        repository.save(memberone);

        Member membertwo = new Member();
        membertwo.setName("izuiw2");
        repository.save(membertwo);

        List<Member> result = repository.findByAll();

        Assertions.assertThat(result.size()).isEqualTo(2);


    }


}
