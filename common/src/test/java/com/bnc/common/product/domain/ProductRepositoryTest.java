package com.bnc.common.product.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void 상품_이름_조회_성공() {
        Product product = productRepository.save(new Product("상품이름1", 15000, "정보1", "브랜드1",0.9));

        Product foundProduct = productRepository.findByProductName(product.getProductName()).orElseThrow();

        Assertions.assertThat(foundProduct.getProductName()).isEqualTo("상품이름1");
    }



}
