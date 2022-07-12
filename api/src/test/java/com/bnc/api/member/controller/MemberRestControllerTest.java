package com.bnc.api.member.controller;

import com.bnc.api.member.controller.dto.MemberCreateDto.MemberCreatRequest;
import com.bnc.api.member.controller.dto.MemberUpdateDto.MemberUpdateRequest;
import com.bnc.api.support.BaseApiTest;
import com.bnc.common.member.domain.Member;
import com.bnc.common.member.domain.MemberRepository;;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static com.bnc.common.member.domain.MemberStatus.DELETED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MemberRestControllerTest extends BaseApiTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void 회원가입_성공() throws Exception {
        val req = new MemberCreatRequest("test", "1","어딘가","01012345678");

        mockMvc.perform(post("/joinMember")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(req)))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.member.userId").value("test")
                );
    }

    @Test
    void 회원_조회_성공() throws Exception{
        val mem = memberRepository.save(new Member("test", "1","어딘가","01012345678"));

        mockMvc.perform(get("/detailMember/{id}", mem.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .param("id",mem.getId().toString()))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.member.userId").value("test"),
                        jsonPath("$.member.password").value("1"),
                        jsonPath("$.member.addr").value("어딘가"),
                        jsonPath("$.member.phone").value("01012345678")
                );
    }

    @Test
    void 회원_수정_성공() throws Exception{
        val member = memberRepository.save(new Member("바보", "1","어딘가","01012345678"));

        MemberUpdateRequest req = new MemberUpdateRequest("바보", "123", "화성", "123");

        mockMvc.perform(patch("/modifyMember").
                contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.member.userId").value("바보"),
                        jsonPath("$.member.password").value("123"),
                        jsonPath("$.member.addr").value("화성"),
                        jsonPath("$.member.phone").value("123")
                );
    }

    @Test
    void 회원_삭제_성공() throws Exception{
        val member = memberRepository.save(new Member("바보", "1","어딘가","01012345678"));

        mockMvc.perform(patch("/deleteMember/{id}", member.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id",member.getId().toString()))
                        .andExpectAll(
                            status().isOk()
                        );
        assertThat(member.getMemberStatus()).isEqualTo(DELETED);
    }
}
