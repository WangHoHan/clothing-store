package com.clothingstore.service;

import com.clothingstore.model.ProductInfo;
import com.clothingstore.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoService {

    private final ProductInfoRepository productInfoRepository;

    @Autowired
    public ProductInfoService(ProductInfoRepository productInfoRepository) {
        this.productInfoRepository = productInfoRepository;
    }

    public ProductInfo updateProductInfo(ProductInfo productInfo, Long id) {
        productInfo.setId(id);
        return productInfoRepository.save(productInfo);
    }
}
