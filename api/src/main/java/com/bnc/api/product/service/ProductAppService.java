package com.bnc.api.product.service;

import com.bnc.api.product.service.dto.ProductCreateDto;
import com.bnc.api.product.service.dto.ProductUpdateDto;
import com.bnc.common.product.domain.Product;

public interface ProductAppService {

    Product createProduct(ProductCreateDto product);

    Product updateProduct(ProductUpdateDto product);

    void removeProduct(long id);
}
