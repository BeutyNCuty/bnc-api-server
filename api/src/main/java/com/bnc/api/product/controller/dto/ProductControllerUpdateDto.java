package com.bnc.api.product.controller.dto;

import com.bnc.common.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class ProductControllerUpdateDto {

    @Getter
    @AllArgsConstructor
    public static class ProductUpdateRequest {
        private long id;
        private String productName;
        private int productPrice;
        private String productInfo;
        private double sale;

        public com.bnc.api.product.service.dto.ProductUpdateDto toDto(){
            return new com.bnc.api.product.service.dto.ProductUpdateDto(this.id , this.productName, this.productPrice , this.productInfo , this.sale);
        }
    }

    @Getter
    @AllArgsConstructor
    public static class ProductUpdateResponse {
        private ProductControllerUpdateDto.ProductUpdateData product;
    }

    @Getter
    @AllArgsConstructor
    @ToString
    public static class ProductUpdateData {

        private long id;
        private String productName;
        private int productPrice;
        private String productInfo;
        private String productBrand;
        private double sale;
        private int salePrice;

        public static ProductControllerUpdateDto.ProductUpdateData updateProduct(Product product){
            return new ProductControllerUpdateDto.ProductUpdateData(product.getId(), product.getProductName(), product.getProductPrice()
                                                                        , product.getProductInfo(), product.getProductBrand(),product.getSale(), product.getSalePrice());
        }
    }
}
