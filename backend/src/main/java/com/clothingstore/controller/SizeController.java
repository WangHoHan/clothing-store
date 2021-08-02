package com.clothingstore.controller;

import com.clothingstore.model.Size;
import com.clothingstore.service.SizeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/size")
@CrossOrigin(origins = "http://localhost:4200")
public class SizeController {

    private final SizeService sizeService;

    public SizeController(SizeService sizeService) {
        this.sizeService = sizeService;
    }

    @GetMapping
    public ResponseEntity<List<Size>> getAllSizes() {
        List<Size> sizes = sizeService.findAllSizes();
        return new ResponseEntity<>(sizes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Size> getProductById(@PathVariable("id") Long id) {
        Size size = sizeService.findSizeById(id);
        return new ResponseEntity<>(size, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Size> updateSize(@RequestBody Size size,
                                           @PathVariable("id") Long id) {
        Size updatedSize = sizeService.updateSize(size, id);
        return new ResponseEntity<>(updatedSize, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSize(@PathVariable("id") Long id) {
        sizeService.deleteSize(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
