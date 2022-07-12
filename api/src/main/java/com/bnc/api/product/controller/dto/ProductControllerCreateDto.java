package com.bnc.api.product.controller.dto;

import com.bnc.common.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


public class ProductControllerCreateDto {

    @Getter
    @AllArgsConstructor
    public static class ProductCreatRequest {
        private String productName;

        private int productPrice;

        private String productInfo;

        private String productBrand;

        private double sale;

        public com.bnc.api.product.service.dto.ProductCreateDto toDto() {
            return new com.bnc.api.product.service.dto.ProductCreateDto(this.productName, this.productPrice, this.productInfo, this.productBrand, this.sale);
        }
    }

    @Getter
    @AllArgsConstructor
    public static class ProductCreateResponse {
        private ProductControllerCreateDto.ProductCreateData product;
    }

    @Getter
    @AllArgsConstructor
    @ToString
    public static class ProductCreateData {

        private long id;
        private String productName;
        private int productPrice;
        private String productInfo;
        private String productBrand;
        private double sale;
        private int salePrice;

        public static ProductControllerCreateDto.ProductCreateData createProduct(Product product){
            return new ProductControllerCreateDto.ProductCreateData(product.getId(), product.getProductName(), product.getProductPrice(),product.getProductInfo(), product.getProductBrand(),product.getSale(), product.getSalePrice());
        }
    }
}
