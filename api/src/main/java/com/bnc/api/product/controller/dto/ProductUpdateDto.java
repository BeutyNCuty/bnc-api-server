package com.bnc.api.product.controller.dto;

import com.bnc.common.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class ProductUpdateDto {

    @Getter
    @AllArgsConstructor
    public static class ProductUpdateRequest {

        private String productName;

        private int productPrice;

        private String productInfo;

        private String productBrand;

        private double sale;

        private int salePrice;

        public  com.bnc.api.product.service.dto.ProductUpdateDto toDto(){
            return new com.bnc.api.product.service.dto.ProductUpdateDto(this.productName, this.productPrice, this.productInfo, this.productBrand, this.sale, this.salePrice);
        }
    }

    @Getter
    @AllArgsConstructor
    public static class ProductUpdateResponse {
        private ProductUpdateData product;
    }

    @Getter
    @AllArgsConstructor
    @ToString
    public static class ProductUpdateData {

        private String productName;

        private int productPrice;

        private String productInfo;

        private String productBrand;

        private double sale;

        private int salePrice;

        public static ProductUpdateData update(Product product) {
            return new ProductUpdateData(product.getProductName(), product.getProductPrice(), product.getProductInfo(), product.getProductBrand(), product.getSale(), product.getSalePrice());
        }
    }
}
