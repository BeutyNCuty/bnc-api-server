package com.bnc.common.category.domain;

import com.bnc.common.product.domain.Product;
import com.bnc.common.product.domain.ProductRepository;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Test
    void 일차_카테고리_생성_성공(){
        final Category category = new Category("cate1");

        Category foundCategory = categoryRepository.save(category);

        Assertions.assertThat(foundCategory.getName()).isEqualTo("cate1");
    }

    @Test
    void 이차_카테고리_생성_생성(){
        final Category category = new Category("cate1");

        final Category categoryFirstChild = new Category("childCate1");
        final Category categorySecondChild = new Category("childCate2");

        category.addChildCategory(categoryFirstChild);
        category.addChildCategory(categorySecondChild);

        Category foudCategory = categoryRepository.save(category);

        Assertions.assertThat(foudCategory.getName()).isEqualTo("cate1");

        Assertions.assertThat(foudCategory.getChild()).containsExactly(categoryFirstChild, categorySecondChild);
    }

    @Test
    void 상품_카테고리에_분류_성공(){
        final Category category = new Category("cate1");

        Category categoryFirstChild = new Category("childCate1");
        Category categorySecondChild = new Category("childCate2");

        List<Product> productList = new ArrayList<>();

        Product product1 = new Product("상품이름1", 15000, "정보1", "브랜드1",0.9);
        Product product2 = new Product("상품이름2", 10000, "정보2", "브랜드2",0.9);

        productList.add(product1);
        productList.add(product2);

        categoryFirstChild.setProducts(productList);

        category.addChildCategory(categoryFirstChild);
        category.addChildCategory(categorySecondChild);

        Category foundCategory = categoryRepository.save(category);

        Assertions.assertThat(foundCategory.getChild().get(0).getProducts()).containsExactly(product1, product2);
    }
}
