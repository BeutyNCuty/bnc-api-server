package com.bnc.common.product.service;

import com.bnc.common.product.domain.Product;
import com.bnc.common.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultProductComService implements ProductComService {

    private final ProductRepository productRepository;

    @Override
    public Product detailProduct(long id) {
        Product product = productRepository.findById(id).orElseThrow();

        return product;
    }
}
