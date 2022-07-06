package com.bnc.api.product.controller;

import com.bnc.api.product.service.ProductAppService;
import com.bnc.common.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class productRestController {

    private final ProductAppService productAppService;

    private final ProductService productService;



}
