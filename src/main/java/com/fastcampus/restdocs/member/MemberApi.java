package com.fastcampus.restdocs.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/members")
@RequiredArgsConstructor
public class MemberApi {

    private final MemberRepository memberRepository;

    @GetMapping("/{id}")
    public MemberResponse getMemberById(
            @PathVariable Long id)
    {
        return new MemberResponse(memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not Found for id: " + id)));
    }

    @PostMapping
    public void createMember(@RequestBody MemberSignUpRequest dto) {
        memberRepository.save(dto.toEntity());
    }

    @PutMapping("/{id}")
    public MemberResponse updateMember(
            @PathVariable Long id,
            @RequestBody @Valid MemberUpdateRequest dto)
    {
        Member member = memberRepository.findById(id).get();
        member.updateName(dto.getName());
        memberRepository.save(member);
        return new MemberResponse(member);
    }

}
