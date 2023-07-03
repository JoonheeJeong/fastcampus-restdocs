package com.fastcampus.restdocs.member;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


@Getter
public class MemberSignUpRequest {

    @Email
    private String email;
    @NotEmpty
    private String name;

    public Member toEntity() {
        return new Member(email, name);
    }
}
