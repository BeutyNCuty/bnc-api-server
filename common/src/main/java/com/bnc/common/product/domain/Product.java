//package com.bnc.common.product.domain;
//
//import com.bnc.common.product.support.BaseEntity;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import org.apache.logging.log4j.util.Strings;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//
//import static com.bnc.common.product.domain.ProductStatus.CREATED;
//import static com.bnc.common.product.domain.ProductStatus.DELETED;
//import static com.google.common.base.Preconditions.checkArgument;
//
//@Entity
//@Getter
//@NoArgsConstructor
//public class Product extends BaseEntity {
//    @Column(nullable = false, name = "product_Name" , unique = true)
//    private String productName;
//
//    private int productPrice;
//
//    private String productInfo;
//
//    private String productBrand;
//
//    private double sale;
//
//    private int salePrice;
//
//
//    @Enumerated(EnumType.STRING)
//    private ProductStatus productStatus = CREATED;
//
//    public Product(String productName, int productPrice, String productInfo, String productBrand , double sale) {
//        checkArgument(Strings.isNotBlank(productName));
//        checkArgument(Strings.isNotBlank(String.valueOf(productPrice)));
//        checkArgument(Strings.isNotBlank(productInfo));
//        checkArgument(Strings.isNotBlank(productBrand));
//
//        this.productName = productName;
//        this.productPrice = productPrice;
//        this.productInfo = productInfo;
//        this.productBrand = productBrand;
//        this.sale = sale;
//        this.salePrice = (int)Math.ceil(productPrice*sale);
//    }
//
//    public void change(String productName, int productPrice, String productInfo){
//        this.productName = productName;
//        this.productPrice = productPrice;
//        this.productInfo = productInfo;
//    }
//    public void change(String productInfo){
//        this.productInfo = productInfo;
//    }
//    public void changeProductName(String productName){
//        this.productName = productName;
//    }
//    public void change(int productPrice){
//        this.productPrice = productPrice;
//    }
//
//    public void deleteProduct(){
//        this.productStatus = DELETED;
//    }
//}
