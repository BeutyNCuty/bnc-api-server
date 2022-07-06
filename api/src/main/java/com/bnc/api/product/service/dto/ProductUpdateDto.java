package com.bnc.api.product.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductUpdateDto {
    private String productName;
    private int productPrice;
    private String productInfo;
    private String productBrand;
    private double sale;
    private int salePrice;
}
