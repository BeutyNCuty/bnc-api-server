package com.bnc.common.member.service;

import com.bnc.common.member.domain.Grade;
import com.bnc.common.member.domain.Member;

import java.util.List;

public interface MemberService  {
    public List<Member> findByGrade(Grade grade);

    public Member checkId(String userId);

    public Member member(long id);

    public void memberWithdrawal(long id);
}
