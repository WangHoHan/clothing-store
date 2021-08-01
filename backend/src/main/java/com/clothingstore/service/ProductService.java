package com.clothingstore.service;

import com.clothingstore.exception.ResourceNotFoundException;
import com.clothingstore.model.*;
import com.clothingstore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductInfoRepository productInfoRepository;

    private final ImageRepository imageRepository;

    private final SizeRepository sizeRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, ProductInfoRepository productInfoRepository, ImageRepository imageRepository, SizeRepository sizeRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productInfoRepository = productInfoRepository;
        this.imageRepository = imageRepository;
        this.sizeRepository = sizeRepository;
        this.categoryRepository = categoryRepository;
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

    public List<Product> findProductsByGender(String name) {
        return productRepository.findProductsByGender(name);
    }

    public List<Product> findProductsByCategory(String name) {
        return productRepository.findProductsByCategory(name);
    }

    public List<Product> findProductsBySubCategory(String name) {
        return productRepository.findProductsBySubCategory(name);
    }

    public List<Product> findProductsByColor(String name) {
        return productRepository.findProductsByColor(name);
    }

    public Product addProduct(Product product, List<Long> categories) {
        if (categories != null) {
            for (Long categoryId: categories) {
                Category category = categoryRepository.findCategoryById(categoryId)
                        .orElseThrow(() -> new ResourceNotFoundException("Category with id " + categoryId + " not found"));
                product.addCategory(category);
            }
        }
        return productRepository.save(product);
    }

    public Size addSizeToProduct(Size size, Long id) {
        Product product = productRepository.findProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        product.setProductSize(size);
        return sizeRepository.save(size);
    }

    public Image addImageToProduct(Image image, Long id) {
        ProductInfo productInfo = productRepository.findProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"))
                .getProductInfo();
        productInfo.setProductImage(image);
        return imageRepository.save(image);
    }

    public Product updateProductCategories(Long id, List<Long> categories) {
        Product product = productRepository.findProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        for (Long categoryId: categories) {
            Category category = categoryRepository.findCategoryById(categoryId)
                    .orElseThrow(() -> new ResourceNotFoundException("Category with id " + categoryId + " not found"));
            product.addCategory(category);
        }
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

    public void deleteProductCategories(Long id, List<Long> categories) {
        Product product = productRepository.findProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));
        for (Long categoryId: categories) {
            Category category = categoryRepository.findCategoryById(categoryId)
                    .orElseThrow(() -> new ResourceNotFoundException("Category with id " + categoryId + " not found"));
            product.removeCategory(category);
            productRepository.save(product);
            categoryRepository.save(category);
        }
    }
}
