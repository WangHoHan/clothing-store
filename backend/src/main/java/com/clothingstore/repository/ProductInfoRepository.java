package com.clothingstore.repository;

import com.clothingstore.model.Product;
import com.clothingstore.model.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfo, Long> {

    ProductInfo findProductInfoByProductId(Long id);
}
