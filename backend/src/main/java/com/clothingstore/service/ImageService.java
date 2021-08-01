package com.clothingstore.service;

import com.clothingstore.exception.ResourceNotFoundException;
import com.clothingstore.model.Image;
import com.clothingstore.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> findAllImages() {
        return imageRepository.findAll();
    }

    public Image findImageById(Long id) {
        return imageRepository.findImageById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Image with id " + id + " not found"));
    }

    public Image updateImage(Image image, Long id) {
        image.setId(id);
        return imageRepository.save(image);
    }

    @Transactional
    public void deleteImage(Long id) {
        imageRepository.deleteImageById(id);
    }
}
