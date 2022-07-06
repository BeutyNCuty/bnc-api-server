package com.bnc.api.product.service;

import com.bnc.api.product.service.dto.ProductCreateDto;
import com.bnc.api.product.service.dto.ProductUpdateDto;
import com.bnc.common.product.domain.Product;
import com.bnc.common.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.val;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class DefaultProductAppService implements ProductAppService {

    private final ProductRepository productRepository;

    @Override
    public Product create(ProductCreateDto dto){
        val product = dto.changeToEntity();

        return productRepository.save(product);
    }

    @Override
    public void update(ProductUpdateDto dto){
       Product byProductName = productRepository.findByProductName(dto.getProductName()).orElseThrow();

       byProductName.change(dto.getProductName(),dto.getProductPrice(),dto.getProductInfo());
    }
}
