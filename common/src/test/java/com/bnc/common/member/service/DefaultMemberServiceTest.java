package com.bnc.common.member.service;

import com.bnc.common.member.domain.Member;
import com.bnc.common.member.domain.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.bnc.common.member.domain.Grade.Bronze;
import static com.bnc.common.member.domain.MemberStatus.DELETED;
import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
@WebAppConfiguration
class DefaultMemberServiceTest {

    @Autowired
    private DefaultMemberService defaultMemberService;

    @Autowired
    private MemberRepository memberRepository;

    private Member member1;
    private Member member2;
    private Member member3;

    @BeforeEach
    void setUp() {
        member1 = memberRepository.save(new Member("aaa121", "123", "지구", "010"));
        member2 = memberRepository.save(new Member("aaa122", "123", "지구", "010"));
        member3 = memberRepository.save(new Member("aaa123", "123", "지구", "010"));
    }

    @Test
    void 등급별_유저_조회_성공() {
        List<Member> foundMember = defaultMemberService.findByGrade(Bronze);

        for (Member member : foundMember) {
            assertThat(member.getGrade()).isEqualTo(Bronze);
        }
    }

    @Test
    void 유저_아이디로_조회_성공(){
        Member foundMember = defaultMemberService.checkId(member1.getUserId());

        assertThat(foundMember.getUserId()).isEqualTo("aaa121");
    }

    @Test
    void 유저_탈퇴_성공(){
        defaultMemberService.memberWithdrawal(member1.getId());

        assertThat(member1.getMemberStatus()).isEqualTo(DELETED);
    }
}