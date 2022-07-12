package com.bnc.common.product.service;

import com.bnc.common.product.domain.Product;
import com.bnc.common.product.domain.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@WebAppConfiguration
class DefaultProductServiceTest {

    @Autowired
    private DefaultProductComService defaultProductService;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void 상품_상세_검색_성공(){
        Product product = productRepository.save(new Product("상품1", 10000, "정보1", "브랜드1", 0.9));

        Product foundProduct = defaultProductService.detailProduct(product.getId());

        Assertions.assertThat(product.getProductName()).isEqualTo(foundProduct.getProductName());
        Assertions.assertThat(product.getProductPrice()).isEqualTo(foundProduct.getProductPrice());
        Assertions.assertThat(product.getProductInfo()).isEqualTo(foundProduct.getProductInfo());
        Assertions.assertThat(product.getProductBrand()).isEqualTo(foundProduct.getProductBrand());
        Assertions.assertThat(product.getSale()).isEqualTo(foundProduct.getSale());
        Assertions.assertThat(product.getId()).isEqualTo(foundProduct.getId());
    }
}
