package com.bnc.common.product.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static com.bnc.common.product.domain.ProductStatus.DELETED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ProductTest {

    @Test
    void 상품_생성_성공(){
        Product product = new Product("상품1" , 10000 , "정보1","브랜드1",0.9);

        assertThat(product.getProductName()).isEqualTo("상품1");
        assertThat(product.getProductPrice()).isEqualTo(10000);
        assertThat(product.getProductInfo()).isEqualTo("정보1");
        assertThat(product.getProductBrand()).isEqualTo("브랜드1");
        assertThat(product.getSale()).isEqualTo(0.9);
        assertThat(product.getSalePrice()).isEqualTo(9000);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 상품이름이_널이거나_빈값이면_실패(String productName){
        assertThatIllegalArgumentException().isThrownBy(() -> new Product(productName, 10000, "정보1", "노브랜드",0.9));
    }

    @Test
    void 상품이름이_공백이면_실패(){
        String productName = "  ";

        assertThatIllegalArgumentException().isThrownBy(() -> new Product(productName, 10000, "정보1", "노브랜드",0.9));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 상품_가격이_널이거나_빈값이면_실패(String productPrice){
        assertThatIllegalArgumentException().isThrownBy(() -> new Product("상품1", Integer.parseInt(productPrice), "정보1", "노브랜드",0.9));
    }

    @Test
    void 상품_가격이_숫자가아니면_실패(){
        String productPrice = " ";

        assertThatIllegalArgumentException().isThrownBy(() -> new Product("상품1", Integer.parseInt(productPrice), "정보1", "노브랜드",0.9));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 브랜드가_널이거나_빈값이면_실패(String productBrand){
        assertThatIllegalArgumentException().isThrownBy(() -> new Product("이름1", 10000, "정보1", productBrand,0.9));
    }

    @Test
    void 브랜드가_공백이면_실패(){
        String productBrand = "  ";

        assertThatIllegalArgumentException().isThrownBy(() -> new Product("이름1", 10000, "정보1", productBrand,0.9));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 상품정보가_널이거나_빈값이면_실패(String productInfo){
        assertThatIllegalArgumentException().isThrownBy(() -> new Product("이름1", 10000, productInfo, "노브랜드",0.9));
    }

    @Test
    void 상품_정보가_공백이면_실패(){
        String productInfo = "  ";

        assertThatIllegalArgumentException().isThrownBy(() -> new Product("이름1", 10000, productInfo, "노브랜드",0.9));
    }

    @Test
    void 상품_변경_성공(){
        Product product = new Product("상품1" , 10000 , "정보1","브랜드1",0.9);

        product.change("상품2" , 20000 , "정보2", 0.8);

        assertThat(product.getProductName()).isEqualTo("상품2");
        assertThat(product.getProductPrice()).isEqualTo(20000);
        assertThat(product.getProductInfo()).isEqualTo("정보2");
        assertThat(product.getProductInfo()).isEqualTo(16000);
    }



    @Test
    void 상품_삭제_성공(){
        Product product = new Product("상품1" , 10000 , "정보1","브랜드1",0.9);

        product.deleteProduct();

        assertThat(product.getProductStatus()).isEqualTo(DELETED);
    }
}
