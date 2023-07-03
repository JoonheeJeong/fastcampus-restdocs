package com.fastcampus.restdocs.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
