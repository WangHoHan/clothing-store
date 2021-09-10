package com.clothingstore.controller;

import com.clothingstore.model.Image;
import com.clothingstore.model.Product;
import com.clothingstore.model.Stock;
import com.clothingstore.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/filters")
    public ResponseEntity<List<Product>> getAllProductsWithFilters(@RequestParam(defaultValue = "0") Integer pageNumber,
                                                                   @RequestParam(defaultValue = "20") Integer pageSize,
                                                                   @RequestParam(required = false) String sortBy,
                                                                   @RequestParam(required = false) String gender,
                                                                   @RequestParam(required = false) String category,
                                                                   @RequestParam(required = false) String subCategory,
                                                                   @RequestParam(defaultValue = "") List<String> color) {
        List<Product> products = productService.findProductsWithFilters(pageNumber, pageSize, sortBy, gender, category, subCategory, color);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @GetMapping("/{id}/stock")
    public ResponseEntity<List<Stock>> getProductStock(@PathVariable("id") Long id) {
        List<Stock> productStock = productService.findProductStock(id);
        return new ResponseEntity<>(productStock, HttpStatus.OK);
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

    @PostMapping("/{id}/stock")
    public ResponseEntity<Stock> addStockToProduct(@RequestBody Stock stock,
                                                   @PathVariable("id") Long id) {
        Stock newStock = productService.addStockToProduct(stock, id);
        return new ResponseEntity<>(newStock, HttpStatus.CREATED);
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

    @PutMapping("/{id}/stock/{stockId}")
    public ResponseEntity<Product> updateProductStock(@RequestBody Stock stock,
                                                      @PathVariable("id") Long id,
                                                      @PathVariable("stockId") Long stockId) {
        Product product = productService.updateProductStock(stock, id, stockId);
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
