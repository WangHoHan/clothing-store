package com.clothingstore.repository;

import com.clothingstore.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SizeRepository extends JpaRepository<Size, Long> {

    List<Size> findSizesByProductId(Long id);

    Optional<Size> findSizeById(Long id);

    void deleteSizeById(Long id);
}
