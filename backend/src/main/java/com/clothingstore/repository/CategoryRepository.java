package com.clothingstore.repository;

import com.clothingstore.model.Category;
import com.clothingstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findCategoryById(Long id);

    void deleteCategoryById(Long id);
}
