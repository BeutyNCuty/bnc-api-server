package com.bnc.api.product.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductUpdateDto {
    private long id;

    private String productName;

    private int productPrice;

    private String productInfo;

    private double sale;

}
