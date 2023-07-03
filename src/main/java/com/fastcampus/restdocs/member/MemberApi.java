package com.fastcampus.restdocs.member;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public void createMember(
            @RequestBody @Valid MemberSignUpRequest dto)
    {
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

    @GetMapping
    public Page<MemberResponse> getMembers(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable)
    {
        return memberRepository.findAll(pageable).map(MemberResponse::new);
    }

}
