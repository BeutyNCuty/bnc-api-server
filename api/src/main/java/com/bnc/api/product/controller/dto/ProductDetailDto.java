package com.bnc.api.product.controller.dto;

import com.bnc.common.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
public class ProductDetailDto {

    @Getter
    @AllArgsConstructor
    public static class ProductDetailResponse {
        private ProductDetailData product;
    }

    @Getter
    @AllArgsConstructor
    @ToString
    public static class ProductDetailData {

        private String productName;

        private int productPrice;

        private String productInfo;

        private String productBrand;

        private double sale;

        private int salePrice;

        public static ProductDetailData detailProduct(Product product){
            return new ProductDetailData(product.getProductName(),product.getProductPrice(), product.getProductInfo(), product.getProductBrand(), product.getSale(), product.getSalePrice());
        }
    }
}
