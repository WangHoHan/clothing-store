package com.clothingstore.controller;

import com.clothingstore.model.Product;
import com.clothingstore.model.Size;
import com.clothingstore.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{id}/sizes")
    public ResponseEntity<List<Size>> getProductSizes(@PathVariable("id") Long id) {
        List<Size> sizes = productService.findProductSizes(id);
        return new ResponseEntity<>(sizes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/size")
    public ResponseEntity<Size> addSizeToProduct(@RequestBody Size size, @PathVariable Long id) {
        Size newSize = productService.addSizeToProduct(size, id);
        return new ResponseEntity<>(newSize, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        Product updatedProduct = productService.updateProduct(product, id);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @PutMapping("/{id}/sizes/{sizeId}")
    public ResponseEntity<Product> updateProductSize(@RequestBody Size size, @PathVariable("id") Long id, @PathVariable("sizeId") Long sizeId) {
        Product product = productService.updateProductSize(size, id, sizeId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
