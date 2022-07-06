package com.bnc.common.member.service;

import com.bnc.common.member.domain.Grade;
import com.bnc.common.member.domain.Member;
import com.bnc.common.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultMemberService implements MemberService {

    private final MemberRepository memberRepository;
    public Member checkId(String userId) {
        return memberRepository.findByUserId(userId).orElseThrow();
    }

    @Override
    public List<Member> findByGrade(Grade grade) {
        return memberRepository.findByGrade(grade);
    }

    @Override
    public Member member(long id) {
        return memberRepository.findById(id).orElseThrow();
    }

    @Override
    public void memberWithdrawal(long id) {
        Member member = memberRepository.findById(id).orElseThrow();

        member.delete();
    }
}
