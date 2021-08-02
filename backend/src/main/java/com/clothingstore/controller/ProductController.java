package com.clothingstore.controller;

import com.clothingstore.model.Image;
import com.clothingstore.model.Product;
import com.clothingstore.model.Size;
import com.clothingstore.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/{id}/size")
    public ResponseEntity<List<Size>> getProductSizes(@PathVariable("id") Long id) {
        List<Size> sizes = productService.findProductSizes(id);
        return new ResponseEntity<>(sizes, HttpStatus.OK);
    }

    @GetMapping("/gender/{name}")
    public ResponseEntity<List<Product>> getProductsByGender(@PathVariable("name") String name) {
        List<Product> products = productService.findProductsByGender(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/category/{name}")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable("name") String name) {
        List<Product> products = productService.findProductsByCategory(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/subCategory/{name}")
    public ResponseEntity<List<Product>> getProductsBySubCategory(@PathVariable("name") String name) {
        List<Product> products = productService.findProductsBySubCategory(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/color/{name}")
    public ResponseEntity<List<Product>> getProductsByColor(@PathVariable("name") String name) {
        List<Product> products = productService.findProductsByColor(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product,
                                              @RequestParam(required = false) List<Long> categories) {
        Product newProduct = productService.addProduct(product, categories);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/size")
    public ResponseEntity<Size> addSizeToProduct(@RequestBody Size size,
                                                 @PathVariable("id") Long id) {
        Size newSize = productService.addSizeToProduct(size, id);
        return new ResponseEntity<>(newSize, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/image")
    public ResponseEntity<Image> addImageToProduct(@RequestBody Image image,
                                                   @PathVariable("id") Long id) {
        Image newImage = productService.addImageToProduct(image, id);
        return new ResponseEntity<>(newImage, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product,
                                                 @PathVariable("id") Long id) {
        Product updatedProduct = productService.updateProduct(product, id);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @PutMapping("/{id}/size/{sizeId}")
    public ResponseEntity<Product> updateProductSize(@RequestBody Size size,
                                                     @PathVariable("id") Long id,
                                                     @PathVariable("sizeId") Long sizeId) {
        Product product = productService.updateProductSize(size, id, sizeId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("{id}/category")
    public ResponseEntity<Product> updateProductCategories(@PathVariable("id") Long id,
                                                           @RequestParam List<Long> categories) {
        Product productWithNewCategory = productService.updateProductCategories(id, categories);
        return new ResponseEntity<>(productWithNewCategory, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}/category")
    public ResponseEntity<?> deleteProductCategory(@PathVariable("id") Long id,
                                                   @RequestParam List<Long> categories) {
        productService.deleteProductCategories(id, categories);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
