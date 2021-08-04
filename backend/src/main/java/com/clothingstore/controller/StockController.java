package com.clothingstore.controller;

import com.clothingstore.model.Stock;
import com.clothingstore.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
@CrossOrigin(origins = "http://localhost:4200")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public ResponseEntity<List<Stock>> getWholeStock() {
        List<Stock> stock = stockService.findWholeStock();
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable("id") Long id) {
        Stock stock = stockService.findStockById(id);
        return new ResponseEntity<>(stock, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStock(@RequestBody Stock stock,
                                             @PathVariable("id") Long id) {
        Stock updatedStock = stockService.updateStock(stock, id);
        return new ResponseEntity<>(updatedStock, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStock(@PathVariable("id") Long id) {
        stockService.deleteStock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
