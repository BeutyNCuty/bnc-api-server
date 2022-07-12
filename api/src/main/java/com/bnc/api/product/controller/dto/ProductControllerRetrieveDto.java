package com.bnc.api.product.controller.dto;

import com.bnc.common.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class ProductControllerRetrieveDto {

    @Getter
    @AllArgsConstructor
    public static class ProductRetrieveResponse {
        private ProductControllerRetrieveDto.ProductRetrieveData product;
    }

    @Getter
    @AllArgsConstructor
    @ToString
    public static class ProductRetrieveData {

        private long id;
        private String productName;
        private int productPrice;
        private String productInfo;
        private String productBrand;
        private double sale;
        private int salePrice;

        public static ProductControllerRetrieveDto.ProductRetrieveData retrieveProduct(Product product){
            return new ProductControllerRetrieveDto.ProductRetrieveData(product.getId(), product.getProductName(), product.getProductPrice(),product.getProductInfo(), product.getProductBrand(),product.getSale(), product.getSalePrice());
        }
    }
}
