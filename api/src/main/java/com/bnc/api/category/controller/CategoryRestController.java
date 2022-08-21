package com.bnc.api.category.controller;

import com.bnc.api.category.controller.dto.CategoryControllerRetrieveDto;
import com.bnc.api.category.controller.dto.CategoryControllerRetrieveDto.CategoryRetrieveData;
import com.bnc.common.category.domain.Category;
import com.bnc.common.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/retrievefirstCategory")
    public List<CategoryRetrieveData> retrievefirstCategory(){
        List<Category> category = categoryService.getFirstCategoryList();

        List<CategoryRetrieveData> cateRetrieveDataList = new ArrayList<CategoryRetrieveData>();

        for (Category firstCategory : category) {
            CategoryRetrieveData tempCate = CategoryRetrieveData.retrieveCategory(firstCategory);

            cateRetrieveDataList.add(tempCate);
        }
        return cateRetrieveDataList;
    }

    @GetMapping("/retrieveChildCategory/{id}")
    public List<CategoryRetrieveData> retrieveChildCategory(@PathVariable long id){
        List<Category> retrieveChildCategory = categoryService.getChildCategory(id);

        List<CategoryRetrieveData> cateRetrieveDataList = new ArrayList<CategoryRetrieveData>();

        for (Category secondCategory : retrieveChildCategory) {
            CategoryRetrieveData retrieveData = CategoryRetrieveData.retrieveCategory(secondCategory);

            cateRetrieveDataList.add(retrieveData);
        }
        return cateRetrieveDataList;
    }
}
