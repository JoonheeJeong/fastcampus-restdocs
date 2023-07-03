package com.fastcampus.restdocs.member;

import lombok.Getter;

@Getter
public class MemberResponse {

    private final Long id;
    private final String email;
    private final String name;

    public MemberResponse(final Member member) {
        id = member.getId();
        email = member.getEmail();
        name = member.getName();
    }
}
