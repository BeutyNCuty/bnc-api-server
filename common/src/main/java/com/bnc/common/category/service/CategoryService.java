package com.bnc.common.category.service;

import com.bnc.common.category.domain.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getFirstCategoryList();

    List<Category> getChildCategory(long id);
}
