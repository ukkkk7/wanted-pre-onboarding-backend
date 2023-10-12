package com.wanted.mission.repository;

import com.wanted.mission.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;


    @Test
    public void testSelect(){

        String id = "cvxc78";


        Optional<Member> result = memberRepository.findById(id);

        if(result.isPresent()){
            Member member = result.get();
            System.out.println("member = " + member);
        }
    }

}
