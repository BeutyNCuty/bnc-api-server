package com.bnc.api.member.service;

import com.bnc.api.member.service.dto.MemberCreateDto;
import com.bnc.api.member.service.dto.MemberUpdateDto;
import com.bnc.common.member.domain.Member;

public interface MemberAppService {
    Member create(MemberCreateDto member);
    Member memberUpdate(MemberUpdateDto member);
}
