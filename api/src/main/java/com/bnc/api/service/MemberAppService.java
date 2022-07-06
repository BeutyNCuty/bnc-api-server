package com.bnc.api.service;

import com.bnc.api.service.dto.MemberCreateDto;
import com.bnc.api.service.dto.MemberUpdateDto;
import com.bnc.common.member.domain.Member;

public interface MemberAppService {
    Member create(MemberCreateDto member);
    Member memberUpdate(MemberUpdateDto member);
}
