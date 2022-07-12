package com.bnc.api.product.service;

import com.bnc.api.product.service.dto.ProductCreateDto;
import com.bnc.api.product.service.dto.ProductUpdateDto;
import com.bnc.common.product.domain.Product;
import com.bnc.common.product.domain.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

import static com.bnc.common.product.domain.ProductStatus.DELETED;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@WebAppConfiguration
class DefaultProductServiceTest {

    @Autowired
    DefaultProductAppService defaultProductService;

    @Autowired
    ProductRepository productRepository;

    @Test
    void 상품_생성_성공() {
        Product product = defaultProductService.createProduct(new ProductCreateDto("상품1", 10000, "정보1", "브랜드1", 0.9));

        assertThat(product.getProductName()).isEqualTo("상품1");
        assertThat(product.getProductPrice()).isEqualTo(10000);
        assertThat(product.getProductInfo()).isEqualTo("정보1");
        assertThat(product.getProductBrand()).isEqualTo("브랜드1");
        assertThat(product.getSale()).isEqualTo(0.9);
        assertThat(product.getSalePrice()).isEqualTo(9000);
    }

    @Test
    void 상품_수정_성공() {
        Product product = productRepository.save(new Product("상품1", 10000, "정보1", "브랜드1", 0.9));

        defaultProductService.updateProduct(new ProductUpdateDto(product.getId(), "상품2", 20000, "정보2",  0.8));

        assertThat(product.getProductName()).isEqualTo("상품2");
        assertThat(product.getProductPrice()).isEqualTo(20000);
        assertThat(product.getProductInfo()).isEqualTo("정보2");
        assertThat(product.getSale()).isEqualTo(0.8);
        assertThat(product.getSalePrice()).isEqualTo(16000);
    }

    @Test
    void 상품_삭제_성공() {
        Product product = productRepository.save(new Product("상품1", 10000, "정보1", "브랜드1", 0.9));

        defaultProductService.removeProduct(product.getId());

        assertThat(product.getProductStatus()).isEqualTo(DELETED);
    }
}
