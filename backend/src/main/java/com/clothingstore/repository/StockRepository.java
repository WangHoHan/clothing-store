package com.clothingstore.repository;

import com.clothingstore.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {

    List<Stock> findStockByProductId(Long id);

    Optional<Stock> findStockById(Long id);

    void deleteStockById(Long id);
}
