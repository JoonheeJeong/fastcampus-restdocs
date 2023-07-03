package com.fastcampus.restdocs.member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberSignUpRequest {

    private final String email;
    private final String name;

    public Member toEntity() {
        return new Member(email, name);
    }
}
