package com.bnc.api.service;

import com.bnc.api.service.dto.MemberCreateDto;
import com.bnc.api.service.dto.MemberUpdateDto;
import com.bnc.common.member.domain.Member;
import com.bnc.common.member.domain.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultMemberAppService implements MemberAppService{

    private final MemberRepository memberRepository;

    @Override
    public Member create(MemberCreateDto dto) {
        val member = new Member(dto.getUserId(), dto.getPassword(), dto.getAddr(), dto.getPhone());

        return memberRepository.save(member);
    }

    @Override
    public Member memberUpdate(MemberUpdateDto dto){
        Member member = memberRepository.findByUserId(dto.getUserId()).orElseThrow();

        member.change(dto.getPassword(), dto.getAddr(), dto.getPhone());

        return member;
    }
}
