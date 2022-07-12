package com.bnc.api.product.service;

import com.bnc.api.product.service.dto.ProductCreateDto;
import com.bnc.api.product.service.dto.ProductUpdateDto;
import com.bnc.common.product.domain.Product;
import com.bnc.common.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultProductAppService implements ProductAppService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct(ProductCreateDto product) {
        Product createdProduct = productRepository.save(product.toEntity());

        return createdProduct;
    }

    @Override
    public Product updateProduct(ProductUpdateDto product) {
        Product foundProduct = productRepository.findById(product.getId()).orElseThrow();

        foundProduct.change(product.getProductName(), product.getProductPrice(), product.getProductInfo(), product.getSale());

        return foundProduct;
    }

    @Override
    public void removeProduct(long id) {
        Product foundProduct = productRepository.findById(id).orElseThrow();

        foundProduct.deleteProduct();
    }
}
