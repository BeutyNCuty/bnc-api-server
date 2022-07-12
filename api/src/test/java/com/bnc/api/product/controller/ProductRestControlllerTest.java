package com.bnc.api.product.controller;

import com.bnc.api.product.controller.dto.ProductControllerUpdateDto;
import com.bnc.api.product.controller.dto.ProductControllerUpdateDto.ProductUpdateRequest;
import com.bnc.api.product.controller.dto.ProductControlllerCreateDto;
import com.bnc.api.product.controller.dto.ProductControlllerCreateDto.ProductCreatRequest;
import com.bnc.api.support.BaseApiTest;
import com.bnc.common.product.domain.Product;
import com.bnc.common.product.domain.ProductRepository;
import com.bnc.common.product.domain.ProductStatus;
import lombok.val;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static com.bnc.common.product.domain.ProductStatus.DELETED;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProductRestControlllerTest extends BaseApiTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void 상품_생성_성공() throws Exception{
        val req = new ProductCreatRequest("상품1", 10000,"어딘가","브랜드1",0.9);

        mockMvc.perform(post("/createProduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.product.productName").value("상품1"),
                        jsonPath("$.product.productPrice").value(10000),
                        jsonPath("$.product.productInfo").value("어딘가"),
                        jsonPath("$.product.productBrand").value("브랜드1"),
                        jsonPath("$.product.sale").value(0.9)
                );
    }

    @Test
    void 상품_수정_성공() throws Exception{
        Product product = productRepository.save(new Product("상품1", 10000,"어딘가","브랜드1",0.9));

        val req = new ProductUpdateRequest(product.getId(), "상품2", 20000,"저긴가",0.8);

        mockMvc.perform(post("/modifyProduct")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(req)))
                .andExpectAll(
                        status().isOk(),
                        jsonPath("$.product.productName").value("상품2"),
                        jsonPath("$.product.productPrice").value(20000),
                        jsonPath("$.product.productInfo").value("저긴가"),
                        jsonPath("$.product.sale").value(0.8),
                        jsonPath("$.product.productBrand").value("브랜드1"),
                        jsonPath("$.product.salePrice").value(16000)
                );
    }

    @Test
    void 상품_삭제_성공()throws Exception{
        Product product = productRepository.save(new Product("상품1", 10000,"어딘가","브랜드1",0.9));

        mockMvc.perform(post("/removeProduct/{id}", product.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .param("id",product.getId().toString()))
                .andExpectAll(
                        status().isOk()
                );
        Assertions.assertThat(product.getProductStatus()).isEqualTo(DELETED);
    }
}
