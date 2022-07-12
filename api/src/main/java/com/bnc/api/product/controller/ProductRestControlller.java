package com.bnc.api.product.controller;

import com.bnc.api.product.controller.dto.ProductControllerCreateDto.ProductCreatRequest;
import com.bnc.api.product.controller.dto.ProductControllerCreateDto.ProductCreateResponse;
import com.bnc.api.product.controller.dto.ProductControllerRetrieveDto;
import com.bnc.api.product.controller.dto.ProductControllerRetrieveDto.ProductRetrieveData;
import com.bnc.api.product.controller.dto.ProductControllerRetrieveDto.ProductRetrieveResponse;
import com.bnc.api.product.service.DefaultProductAppService;
import com.bnc.common.product.domain.Product;
import com.bnc.common.product.service.DefaultProductComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.bnc.api.product.controller.dto.ProductControllerUpdateDto.*;
import static com.bnc.api.product.controller.dto.ProductControllerCreateDto.ProductCreateData.createProduct;

@RestController
public class ProductRestControlller {

    @Autowired
    private DefaultProductAppService defaultProductAppService;

    @Autowired
    private DefaultProductComService defaultProductComService;
    
    @PostMapping("/createProduct")
    public ProductCreateResponse registerProduct(@RequestBody ProductCreatRequest productCreateDto){
        Product product = defaultProductAppService.createProduct(productCreateDto.toDto());

        return new ProductCreateResponse(createProduct(product));
    }

    @PostMapping("/modifyProduct")
    public ProductUpdateResponse updateProduct(@RequestBody ProductUpdateRequest productUpdateDto){
        Product product = defaultProductAppService.updateProduct(productUpdateDto.toDto());

        return new ProductUpdateResponse(ProductUpdateData.updateProduct(product));
    }

    @PostMapping("/removeProduct/{id}")
    public void withdrawProduct(@PathVariable Long id){
        defaultProductAppService.removeProduct(id);
    }
    
    @GetMapping("/detailProduct/{id}")
    public ProductRetrieveResponse retrieveProduct(@PathVariable long id){
        Product product = defaultProductComService.detailProduct(id);
        
        return new ProductRetrieveResponse(ProductRetrieveData.retrieveProduct(product));
    }
}
