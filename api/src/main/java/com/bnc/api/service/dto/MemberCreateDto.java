package com.bnc.api.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberCreateDto {
    private String userId;
    private String password;
    private String addr;
    private String phone;
}
