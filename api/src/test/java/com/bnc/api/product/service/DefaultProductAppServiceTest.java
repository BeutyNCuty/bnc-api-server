package com.bnc.api.product.service;


import com.bnc.api.product.service.dto.ProductCreateDto;
import com.bnc.common.product.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@WebAppConfiguration
class DefaultProductAppServiceTest {

    @Autowired
    private DefaultProductAppService defaultProductAppService;

    @Test
    void 상품_등록_성공(){
        ProductCreateDto product = new ProductCreateDto("상품1",10000, "짱예쁨","BNC", 0.9);

        Product checkProduct = defaultProductAppService.create(product);

        Assertions.assertThat(checkProduct.getProductName()).isEqualTo("상품1");
        Assertions.assertThat(checkProduct.getProductPrice()).isEqualTo(10000);
        Assertions.assertThat(checkProduct.getProductInfo()).isEqualTo("짱예쁨");
        Assertions.assertThat(checkProduct.getProductBrand()).isEqualTo("BNC");
        Assertions.assertThat(checkProduct.getSale()).isEqualTo(0.9);
        Assertions.assertThat(checkProduct.getSalePrice()).isEqualTo(9000);
    }
}
