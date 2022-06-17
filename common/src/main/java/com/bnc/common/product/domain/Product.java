package com.bnc.common.product.domain;

import com.bnc.common.support.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import static com.bnc.common.product.domain.ProductStatus.CREATED;
import static com.bnc.common.product.domain.ProductStatus.DELETED;
import static com.google.common.base.Preconditions.checkArgument;

@Entity
@Getter
@NoArgsConstructor
public class Product extends BaseEntity {

    private String productName;

    private int productPrice;

    private String productInfo;

    private String productBrand;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus = CREATED;

    public Product(String productName, int productPrice, String productInfo, String productBrand) {
        checkArgument(Strings.isNotBlank(productName));
        checkArgument(Strings.isNotBlank(String.valueOf(productPrice)));
        checkArgument(Strings.isNotBlank(productInfo));
        checkArgument(Strings.isNotBlank(productBrand));

        this.productName = productName;
        this.productPrice = productPrice;
        this.productInfo = productInfo;
        this.productBrand = productBrand;
    }

    public void change(Product product){
        this.productName = product.getProductName();
        this.productBrand = product.getProductBrand();
        this.productInfo = product.getProductInfo();
        this.productPrice= product.getProductPrice();
    }

    public void deleteProduct(){
        this.productStatus = DELETED;
    }
}
