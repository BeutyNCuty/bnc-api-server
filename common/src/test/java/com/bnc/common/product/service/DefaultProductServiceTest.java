package com.bnc.common.product.service;

import com.bnc.common.product.domain.Product;
import com.bnc.common.product.domain.ProductRepository;
import com.bnc.common.product.domain.ProductStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static com.bnc.common.product.domain.ProductStatus.*;

@Transactional
@SpringBootTest
@WebAppConfiguration
class DefaultProductServiceTest {


    @Autowired
    private DefaultProductService defaultProductService;

    @Autowired
    private ProductRepository productRepository;

    private Product product1;
    private Product product2;
    private Product product3;

    @BeforeEach
    void setUp() {
        product1 = productRepository.save(new Product("상품1", 10000, "정보1", "브랜드1",0.9));
        product2 = productRepository.save(new Product("상품2", 10000, "정보2", "브랜드2",0.9));
        product3 = productRepository.save(new Product("상품3", 10000, "정보3", "브랜드3",0.9));

    }

    @Test
    void 상품_이름으로_조회_성공(){
        Product product = defaultProductService.checkProductName("상품1");

        Assertions.assertThat(product.getProductName()).isEqualTo("상품1");
        Assertions.assertThat(product.getProductPrice()).isEqualTo(10000);
        Assertions.assertThat(product.getProductInfo()).isEqualTo("정보1");
        Assertions.assertThat(product.getProductBrand()).isEqualTo("브랜드1");
        Assertions.assertThat(product.getSalePrice()).isEqualTo(9000);
    }

    @Test
    void 상품_삭제_성공(){
        defaultProductService.productWithdrawal(product1.getId());

        Assertions.assertThat(product1.getProductStatus()).isEqualTo(DELETED);
    }
}
