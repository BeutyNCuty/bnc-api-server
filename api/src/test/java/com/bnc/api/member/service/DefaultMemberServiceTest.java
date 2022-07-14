package com.bnc.api.member.service;

import com.bnc.api.member.service.dto.MemberCreateDto;
import com.bnc.api.member.service.dto.MemberUpdateDto;
import com.bnc.common.member.domain.Member;
import com.bnc.common.member.domain.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static com.bnc.common.member.domain.MemberStatus.DELETED;

@SpringBootTest
@Transactional
@WebAppConfiguration
public class DefaultMemberServiceTest {

    @Autowired
    DefaultMemberAppService defaultMemberAppService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 멤버_생성_성공(){
        Member member = defaultMemberAppService.createMember(new MemberCreateDto("aa","bb","123","12345678"));

        Assertions.assertThat(member.getId()).isEqualTo("aa");
        Assertions.assertThat(member.getPassword()).isEqualTo("bb");
        Assertions.assertThat(member.getAddr()).isEqualTo("123");
        Assertions.assertThat(member.getPhone()).isEqualTo("12345678");
    }

    @Test
    void 멤버_수정_성공(){
        Member save = memberRepository.save(new Member("이름", "비밀번호", "주소", "폰"));

        defaultMemberAppService.memberUpdate(new MemberUpdateDto(save.getUserId(),"bb","123","12345678"));

        Assertions.assertThat(save.getPassword()).isEqualTo("bb");
        Assertions.assertThat(save.getAddr()).isEqualTo("123");
        Assertions.assertThat(save.getPhone()).isEqualTo("12345678");
    }

    @Test
    void 멤버_삭제_성공(){
        Member save = memberRepository.save(new Member("이름", "비밀번호", "주소", "폰"));

        defaultMemberAppService.removeMember(save.getId());

        Assertions.assertThat(save.getMemberStatus()).isEqualTo(DELETED);
    }
}
