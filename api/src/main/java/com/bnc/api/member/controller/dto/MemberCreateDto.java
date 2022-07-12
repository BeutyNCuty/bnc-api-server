package com.bnc.api.member.controller.dto;

import com.bnc.common.member.domain.Grade;
import com.bnc.common.member.domain.Member;
import com.bnc.common.member.domain.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;

public class MemberCreateDto {


    @Getter
    @AllArgsConstructor
    public static class MemberCreatRequest {
        private String userId;
        private String password;
        private String addr;
        private String phone;

        public com.bnc.api.member.service.dto.MemberCreateDto toDto(){
            return new com.bnc.api.member.service.dto.MemberCreateDto(this.userId, this.password, this.addr, this.phone);
        }
    }

    @Getter
    @AllArgsConstructor
    public static class MemberCreateResponse {
        private MemberCreateData member;
    }

    @Getter
    @AllArgsConstructor
    @ToString
    public static class MemberCreateData {
        private String userId;
        private String password;
        private String addr;
        private String phone;
        private Grade grade;
        private long totalPrice;
        private OffsetDateTime creatAt ;
        private MemberStatus memberStatus;

        public static MemberCreateData createMember(Member member){
            return new MemberCreateData(member.getUserId(), member.getPassword(), member.getAddr(),
                    member.getPhone(), member.getGrade(), member.getTotalPrice(), member.getCreatAt(), member.getMemberStatus());
        }
    }
}
