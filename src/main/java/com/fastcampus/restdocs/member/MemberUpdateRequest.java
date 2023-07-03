package com.fastcampus.restdocs.member;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class MemberUpdateRequest {

    @NotEmpty
    private String name;
}
