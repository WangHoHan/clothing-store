package com.clothingstore.repository;

import com.clothingstore.model.OrderContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderContentRepository extends JpaRepository<OrderContent, Long> {

    @Modifying
    @Query("DELETE FROM OrderContent c WHERE c.order.id = :orderId AND c.product.id = :productId AND c.size = :size")
    void deleteContentFromOrder(@Param("orderId") Long orderId,
                                @Param("productId") Long productId,
                                @Param("size") String size);
}
