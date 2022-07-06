package com.bnc.api.product.service.dto;

import com.bnc.common.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class ProductCreateDto {
    private String productName;
    private int productPrice;
    private String productInfo;
    private String productBrand;
    private double sale;

    public Product changeToEntity(){
        return new Product(this.productName, this.productPrice, this.productInfo, this.productBrand, this.sale);
    }
}
