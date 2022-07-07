package com.bnc.common.product.service;

import com.bnc.common.product.domain.Product;
import com.bnc.common.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultProductService implements ProductService{

    private final ProductRepository productRepository;

    @Override
    public Product checkProductName(String productName) {
        return  productRepository.findByProductName(productName).orElseThrow();
    }

    @Override
    public void productWithdrawal(long id){
        Product product = productRepository.findById(id).orElseThrow();

        product.deleteProduct();
    }
}
