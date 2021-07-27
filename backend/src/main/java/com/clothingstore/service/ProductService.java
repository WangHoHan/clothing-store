package com.clothingstore.service;

import com.clothingstore.exception.ProductNotFoundException;
import com.clothingstore.model.Product;
import com.clothingstore.model.ProductInfo;
import com.clothingstore.repository.ProductInfoRepository;
import com.clothingstore.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductInfoRepository productInfoRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductInfoRepository productInfoRepository) {
        this.productRepository = productRepository;
        this.productInfoRepository = productInfoRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
    }

    public Product addProduct(Product product) {
        ProductInfo productInfo = product.getProductInfo();
        productInfoRepository.save(productInfo);
        return productRepository.save(product);
    }

    public Product updateProduct(Product product, Long id) {
        product.setId(id);
        if (product.getProductInfo() == null) {
            ProductInfo productInfo = productInfoRepository.findProductInfoByProductId(product.getId());
            product.setProductInfo(productInfo);
        }
        return productRepository.save(product);
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteProductById(id);
    }
}
