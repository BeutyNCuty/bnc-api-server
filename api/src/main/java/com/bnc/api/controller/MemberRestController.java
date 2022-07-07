package com.bnc.api.controller;

import com.bnc.common.member.service.MemberService;
import com.bnc.api.controller.dto.MemberCreateDto.MemberCreatRequest;
import com.bnc.api.controller.dto.MemberCreateDto.MemberCreateData;
import com.bnc.api.controller.dto.MemberCreateDto.MemberCreateResponse;
import com.bnc.api.controller.dto.MemberDetailDto.MemberDetailResponse;
import com.bnc.api.service.MemberAppService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.*;

import static com.bnc.api.controller.dto.MemberDetailDto.MemberDetailData.readMember;
import static com.bnc.api.controller.dto.MemberUpdateDto.MemberUpdateData.update;
import static com.bnc.api.controller.dto.MemberUpdateDto.MemberUpdateRequest;
import static com.bnc.api.controller.dto.MemberUpdateDto.MemberUpdateResponse;


@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberAppService memberAppService;

    private final MemberService memberService;

    @PostMapping("/joinMember")
    public MemberCreateResponse createMember(@RequestBody MemberCreatRequest req){
        val member = memberAppService.create(req.toDto());

       return new MemberCreateResponse(MemberCreateData.createMember(member));
    }

    @GetMapping("/detailMember/{id}")
    public MemberDetailResponse detailMember(@PathVariable long id){
        val member = memberService.member(id);

        return new MemberDetailResponse(readMember(member));
    }

    @PatchMapping("/modifyMember")
    public MemberUpdateResponse modifyMember(@RequestBody MemberUpdateRequest req){
        val member = memberAppService.memberUpdate(req.toDto());

        return new MemberUpdateResponse(update(member));
    }

    @PatchMapping("/deleteMember/{id}")
    public void deleteMember(@PathVariable long id){
        memberService.memberWithdrawal(id);
    }
}
