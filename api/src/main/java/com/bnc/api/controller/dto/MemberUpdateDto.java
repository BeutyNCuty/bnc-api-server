package com.bnc.api.controller.dto;

import com.bnc.common.member.domain.Grade;
import com.bnc.common.member.domain.Member;
import com.bnc.common.member.domain.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;

public class MemberUpdateDto {

    @Getter
    @AllArgsConstructor
    public static class MemberUpdateRequest {
        private String userId;
        private String password;
        private String addr;
        private String phone;

        public com.bnc.api.service.dto.MemberUpdateDto toDto(){
            return new com.bnc.api.service.dto.MemberUpdateDto(this.userId ,this.password, this.addr, this.phone);
        }
    }

    @Getter
    @AllArgsConstructor
    public static class MemberUpdateResponse {
        private MemberUpdateData member;
    }

    @Getter
    @AllArgsConstructor
    @ToString
    public static class MemberUpdateData {
        private String userId;
        private String password;
        private String addr;
        private String phone;
        private Grade grade;
        private long totalPrice;
        private OffsetDateTime creatAt ;
        private MemberStatus memberStatus;

        public static MemberUpdateData update(Member member){
            return new MemberUpdateData(member.getUserId(), member.getPassword(), member.getAddr(),
                    member.getPhone(), member.getGrade(), member.getTotalPrice(), member.getCreatAt(), member.getMemberStatus());
        }
    }
}
