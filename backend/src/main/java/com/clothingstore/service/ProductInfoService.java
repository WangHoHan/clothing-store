package com.clothingstore.service;

import com.clothingstore.model.ProductInfo;
import com.clothingstore.repository.ImageRepository;
import com.clothingstore.repository.ProductInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInfoService {

    private final ProductInfoRepository productInfoRepository;

    private final ImageRepository imageRepository;

    @Autowired
    public ProductInfoService(ProductInfoRepository productInfoRepository, ImageRepository imageRepository) {
        this.productInfoRepository = productInfoRepository;
        this.imageRepository = imageRepository;
    }

    public ProductInfo updateProductInfo(ProductInfo productInfo, Long id) {
        productInfo.setId(id);
        if (productInfo.getImages().isEmpty()) {
            productInfo.setImages(imageRepository.findImagesByProductInfoId(id));
        }
        return productInfoRepository.save(productInfo);
    }
}
