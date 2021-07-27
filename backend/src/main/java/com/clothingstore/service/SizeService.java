package com.clothingstore.service;

import com.clothingstore.exception.ResourceNotFoundException;
import com.clothingstore.model.Size;
import com.clothingstore.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SizeService {

    private final SizeRepository sizeRepository;

    @Autowired
    public SizeService(SizeRepository sizeRepository) {
        this.sizeRepository = sizeRepository;
    }

    public List<Size> findAllSizes() {
        return sizeRepository.findAll();
    }

    public Size findSizeById(Long id) {
        return sizeRepository.findSizeById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Size with id " + id + " not found"));
    }

    public Size updateSize(Size size, Long id) {
        size.setId(id);
        return sizeRepository.save(size);
    }

    @Transactional
    public void deleteSize(Long id) {
        sizeRepository.deleteSizeById(id);
    }
}
