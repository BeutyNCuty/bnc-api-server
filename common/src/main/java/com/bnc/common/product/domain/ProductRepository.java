package com.bnc.common.product.domain;

import com.bnc.common.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

        @Query("select p from Product p where p.productName = :productName")
        Optional<Product> findByProductName(String productName );
}
