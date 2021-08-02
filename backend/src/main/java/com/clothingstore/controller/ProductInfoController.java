package com.clothingstore.controller;

import com.clothingstore.model.ProductInfo;
import com.clothingstore.service.ProductInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productInfo")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductInfoController {

    private final ProductInfoService productInfoService;

    public ProductInfoController(ProductInfoService productInfoService) {
        this.productInfoService = productInfoService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductInfo> updateProductInfo(@RequestBody ProductInfo productInfo,
                                                         @PathVariable("id") Long id) {
        ProductInfo updatedInfo = productInfoService.updateProductInfo(productInfo, id);
        return new ResponseEntity<>(updatedInfo, HttpStatus.OK);
    }
}
