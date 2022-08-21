package com.bnc.common.category.service;

import com.bnc.common.category.domain.Category;
import com.bnc.common.category.domain.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
@Transactional
@WebAppConfiguration
class DefaultCategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void 일차_카테고리_조회_성공(){
        Category cate1 = categoryRepository.save(new Category("cate1"));

        List<Category> foundCategory = categoryService.getFirstCategoryList();

        Assertions.assertThat(foundCategory).contains(cate1);
    }

}