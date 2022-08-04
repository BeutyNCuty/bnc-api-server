package com.bnc.api.category.service.dto;

import com.bnc.common.category.domain.Category;
import com.bnc.common.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CategoryCreateDto {

    String name;

    Category parent;

    List<Product> products;
}
