package com.bnc.api.member.controller.dto;

import com.bnc.common.member.domain.Grade;
import com.bnc.common.member.domain.Member;
import com.bnc.common.member.domain.MemberStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.OffsetDateTime;

@Getter
@AllArgsConstructor
public class MemberDetailDto {

    @Getter
    @AllArgsConstructor
    public static class MemberDetailResponse {
        private MemberDetailData member;
    }

    @Getter
    @AllArgsConstructor
    @ToString
    public static class MemberDetailData {
        private String userId;
        private String password;
        private String addr;
        private String phone;
        private Grade grade;
        private long totalPrice;
        private OffsetDateTime creatAt ;
        private MemberStatus memberStatus;

        public static MemberDetailData readMember(Member member){
            return new MemberDetailData(member.getUserId(), member.getPassword(), member.getAddr(),
                    member.getPhone(), member.getGrade(), member.getTotalPrice(), member.getCreatAt(), member.getMemberStatus());
        }
    }
}
