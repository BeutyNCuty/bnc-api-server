package com.bnc.common.product.domain;

import com.bnc.common.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Member, Long> {
}
