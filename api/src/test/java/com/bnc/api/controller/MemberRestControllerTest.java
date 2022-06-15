package com.bnc.api.controller;

import com.bnc.api.controller.dto.MemberCreateDto;
import com.bnc.api.controller.dto.MemberCreateDto.MemberCreatRequest;
import com.bnc.api.support.BaseApiTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class MemberRestControllerTest extends BaseApiTest {

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
}