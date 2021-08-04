package com.clothingstore.service;

import com.clothingstore.exception.ResourceNotFoundException;
import com.clothingstore.model.Stock;
import com.clothingstore.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StockService {

    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> findWholeStock() {
        return stockRepository.findAll();
    }

    public Stock findStockById(Long id) {
        return stockRepository.findStockById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Stock with id " + id + " not found"));
    }

    public Stock updateStock(Stock stock, Long id) {
        stock.setId(id);
        return stockRepository.save(stock);
    }

    @Transactional
    public void deleteStock(Long id) {
        stockRepository.deleteStockById(id);
    }
}
