package com.bnc.common.category;

import com.bnc.common.category.domain.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CategoryTest {

    @Test
    void 카테고리_생성_성공(){
        final Category category = new Category("Top");

        assertThat(category.getName()).isEqualTo("Top");
    }

    @NullAndEmptySource
    @ParameterizedTest
    void 카테고리가_null이거나_빈값이면_성공(String name){
        assertThatIllegalArgumentException().isThrownBy(() -> new Category(name));
    }
}
