package com.fastcampus.restdocs;

import com.fastcampus.restdocs.member.Member;
import com.fastcampus.restdocs.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataSetup implements ApplicationRunner {

    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Member> memberList = new ArrayList<>();

        memberList.add(new Member("yun@abc.com", "yun"));
        memberList.add(new Member("jo@abc.com", "jo"));
        memberList.add(new Member("jin@abc.com", "jin"));
        memberList.add(new Member("se@abc.com", "se"));

        memberRepository.saveAll(memberList);
    }
}
