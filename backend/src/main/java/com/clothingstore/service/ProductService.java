package com.clothingstore.service;

import com.clothingstore.exception.ResourceNotFoundException;
import com.clothingstore.model.Product;
import com.clothingstore.model.ProductInfo;
import com.clothingstore.model.Size;
import com.clothingstore.repository.ProductInfoRepository;
import com.clothingstore.repository.ProductRepository;
import com.clothingstore.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductInfoRepository productInfoRepository;

    private final SizeRepository sizeRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductInfoRepository productInfoRepository, SizeRepository sizeRepository) {
        this.productRepository = productRepository;
        this.productInfoRepository = productInfoRepository;
        this.sizeRepository = sizeRepository;
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public Product findProductById(Long id) {
        return productRepository.findProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
    }

    public List<Size> findProductSizes(Long id) {
        return sizeRepository.findSizesByProductId(id);
    }

    public Product addProduct(Product product) {
        ProductInfo productInfo = product.getProductInfo();
        productInfoRepository.save(productInfo);
        return productRepository.save(product);
    }

    public Size addSizeToProduct(Size size, Long id) {
        Product product = productRepository.findProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        size.setProduct(product);
        product.getSizes().add(size);
        return sizeRepository.save(size);
    }

    public Product updateProduct(Product product, Long id) {
        product.setId(id);
        if (product.getProductInfo() == null) {
            ProductInfo productInfo = productInfoRepository.findProductInfoByProductId(product.getId());
            product.setProductInfo(productInfo);
        }
        return productRepository.save(product);
    }

    public Product updateProductSize(Size size, Long id, Long sizeId) {
        size.setId(sizeId);
        Product product = productRepository.findProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        size.setProduct(product);
        sizeRepository.save(size);
        return product;
    }

    @Transactional
    public void deleteProduct(Long id) {
        productRepository.deleteProductById(id);
    }
}
