package com.bnc.common.category;

import com.bnc.common.category.domain.Category;
import com.bnc.common.category.domain.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class CategoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void 카테고리_생성_성공(){
        final Category category = new Category("Top");

        Assertions.assertThat(category.getName()).isEqualTo("Top");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 카테고리가_null_이거나_빈값_이면_실패(String name){
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> new Category(name));
    }
}
