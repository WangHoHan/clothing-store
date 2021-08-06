package com.clothingstore.repository;

import com.clothingstore.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findImageById(Long id);

    void deleteImageById(Long id);

    List<Image> findImagesByProductInfoId(Long id);
}
