package com.clothingstore.repository;

import com.clothingstore.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findStockByProductId(Long id);

    Optional<Stock> findStockByProductIdAndSizeTag(Long id, String sizeTag);

    Optional<Stock> findStockById(Long id);

    @Modifying
    @Query("UPDATE Stock s SET s.quantity = s.quantity - :quantity WHERE s.product.id = :id AND s.sizeTag = :size")
    void buyProducts(Integer quantity, Long id, String size);

    void deleteStockById(Long id);
}
