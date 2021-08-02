package com.clothingstore.controller;

import com.clothingstore.model.Image;
import com.clothingstore.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
@CrossOrigin(origins = "http://localhost:4200")
public class ImageController {

    public final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> images = imageService.findAllImages();
        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageById(@PathVariable("id") Long id) {
        Image image = imageService.findImageById(id);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(@RequestBody Image image,
                                           @PathVariable("id") Long id) {
        Image updatedImage = imageService.updateImage(image, id);
        return new ResponseEntity<>(updatedImage, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteImage(@PathVariable("id") Long id) {
        imageService.deleteImage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
