package com.clothingstore.repository;

import com.clothingstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findProductById(Long id);

    List<Product> findProductsByGender(String name);

    @Query(value = "SELECT * FROM product p JOIN product_categories pc ON p.id = pc.product_id JOIN category c ON c.id = pc.category_id WHERE c.name = :name", nativeQuery = true)
    List<Product> findProductsByCategory(@Param("name") String name);

    @Query(value = "SELECT * FROM product p JOIN product_categories pc ON p.id = pc.product_id JOIN category c ON c.id = pc.category_id WHERE c.sub_category = :name", nativeQuery = true)
    List<Product> findProductsBySubCategory(@Param("name") String name);

    @Query("SELECT p FROM Product p JOIN ProductInfo i ON p.productInfo = i WHERE i.color = :name")
    List<Product> findProductsByColor(@Param("name") String name);

    void deleteProductById(Long id);
}