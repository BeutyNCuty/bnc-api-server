package com.bnc.common.product.service;

import com.bnc.common.product.domain.Product;

public interface ProductService {

    public Product checkProductName(String productName);

    public void productWithdrawal(long id);

}
