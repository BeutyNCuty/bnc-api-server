package com.bnc.api.product.controller;

import com.bnc.api.product.controller.dto.ProductControllerUpdateDto;
import com.bnc.api.product.controller.dto.ProductControlllerCreateDto;
import com.bnc.api.product.controller.dto.ProductControlllerCreateDto.ProductCreatRequest;
import com.bnc.api.product.controller.dto.ProductControlllerCreateDto.ProductCreateResponse;
import com.bnc.api.product.service.DefaultProductService;
import com.bnc.common.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.bnc.api.product.controller.dto.ProductControllerUpdateDto.*;
import static com.bnc.api.product.controller.dto.ProductControlllerCreateDto.ProductCreateData.createProduct;

@RestController
public class ProductRestControlller {

    @Autowired
    private DefaultProductService defaultProductService;

    @PostMapping("/createProduct")
    public ProductCreateResponse registerProduct(@RequestBody ProductCreatRequest productCreateDto){
        Product product = defaultProductService.createProduct(productCreateDto.toDto());

        return new ProductCreateResponse(createProduct(product));
    }

    @PostMapping("/modifyProduct")
    public ProductUpdateResponse updateProduct(@RequestBody ProductUpdateRequest productUpdateDto){
        Product product = defaultProductService.updateProduct(productUpdateDto.toDto());

        return new ProductUpdateResponse(ProductUpdateData.updateProduct(product));
    }

    @PostMapping("/removeProduct/{id}")
    public void removeProduct(@PathVariable Long id){
        defaultProductService.removeProduct(id);
    }
}
