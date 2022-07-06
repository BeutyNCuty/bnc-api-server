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
        Product product = new Product("상품1" , 10000 , "정보1","브랜드1");

        assertThat(product.getProductName()).isEqualTo("상품1");
        assertThat(product.getProductPrice()).isEqualTo(10000);
        assertThat(product.getProductInfo()).isEqualTo("정보1");
        assertThat(product.getProductBrand()).isEqualTo("브랜드1");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 상품이름이_널이거나_빈값이면_실패(String productName){
        assertThatIllegalArgumentException().isThrownBy(() -> new Product(productName, 10000, "정보1", "노브랜드"));
    }

    @Test
    void 상품이름이_공백이면_실패(){
        String productName = "  ";

        assertThatIllegalArgumentException().isThrownBy(() -> new Product(productName, 10000, "정보1", "노브랜드"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 상품_가격이_널이거나_빈값이면_실패(String productPrice){
        assertThatIllegalArgumentException().isThrownBy(() -> new Product("상품1", Integer.parseInt(productPrice), "정보1", "노브랜드"));
    }

    @Test
    void 상품_가격이_숫자가아니면_실패(){
        String productPrice = " ";

        assertThatIllegalArgumentException().isThrownBy(() -> new Product("상품1", Integer.parseInt(productPrice), "정보1", "노브랜드"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 브랜드가_널이거나_빈값이면_실패(String productBrand){
        assertThatIllegalArgumentException().isThrownBy(() -> new Product("이름1", 10000, "정보1", productBrand));
    }

    @Test
    void 브랜드가_공백이면_실패(){
        String productBrand = "  ";

        assertThatIllegalArgumentException().isThrownBy(() -> new Product("이름1", 10000, "정보1", productBrand));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 상품정보가_널이거나_빈값이면_실패(String productInfo){
        assertThatIllegalArgumentException().isThrownBy(() -> new Product("이름1", 10000, productInfo, "노브랜드"));
    }

    @Test
    void 상품_정보가_공백이면_실패(){
        String productInfo = "  ";

        assertThatIllegalArgumentException().isThrownBy(() -> new Product("이름1", 10000, productInfo, "노브랜드"));
    }

    @Test
    void 상품_변경_성공(){
        Product product = new Product("상품1" , 10000 , "정보1","브랜드1");

        product.change("상품2" , 20000 , "정보2");

        assertThat(product.getProductName()).isEqualTo("상품2");
        assertThat(product.getProductPrice()).isEqualTo(20000);
        assertThat(product.getProductInfo()).isEqualTo("정보2");
    }

    @Test
    void 상품_이름_변경_성공(){
        Product product = new Product("상품1" , 10000 , "정보1","브랜드1");

        product.changeProductName("상품2");

        Assertions.assertThat(product.getProductName()).isEqualTo("상품2");
    }

    @Test
    void 상품_정보_변경_성공(){
        Product product = new Product("상품1" , 10000 , "정보1","브랜드1");

        product.change("정보2");

        Assertions.assertThat(product.getProductInfo()).isEqualTo("정보2");
    }

    @Test
    void 상품_가격_변경_성공(){
        Product product = new Product("상품1" , 10000 , "정보1","브랜드1");

        product.change(20000);

        Assertions.assertThat(product.getProductPrice()).isEqualTo(20000);
    }

    @Test
    void 상품_삭제_성공(){
        Product product = new Product("상품1" , 10000 , "정보1","브랜드1");

        product.deleteProduct();

        assertThat(product.getProductStatus()).isEqualTo(DELETED);
    }
}
