package com.bnc.common.category.service;

import com.bnc.common.category.domain.Category;
import com.bnc.common.category.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCategoryService implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getFirstCategoryList() {

        return categoryRepository.selectFirstCategoryList();
    }

    @Override
    public List<Category> getChildCategory(long id) {
        Category category = categoryRepository.findById(id).orElseThrow();

        return category.getChild();
    }
}
