package com.clothingstore.repository;

import com.clothingstore.model.ShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShippingInfoRepository extends JpaRepository<ShippingInfo, Long> {

    @Query("SELECT o.shippingInfo FROM Order o WHERE o.id = :id")
    ShippingInfo findShippingInfoByOrderId(@Param("id") Long id);
}
