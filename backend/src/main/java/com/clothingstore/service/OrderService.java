package com.clothingstore.service;

import com.clothingstore.exception.InvalidRequestException;
import com.clothingstore.exception.ResourceNotFoundException;
import com.clothingstore.model.*;
import com.clothingstore.model.purchase.PurchaseContent;
import com.clothingstore.model.purchase.Purchase;
import com.clothingstore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final ShippingInfoRepository shippingInfoRepository;

    private final ProductRepository productRepository;

    private final StockRepository stockRepository;

    private final OrderContentRepository contentRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ShippingInfoRepository shippingInfoRepository, ProductRepository productRepository, StockRepository stockRepository, OrderContentRepository contentRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.shippingInfoRepository = shippingInfoRepository;
        this.productRepository = productRepository;
        this.stockRepository = stockRepository;
        this.contentRepository = contentRepository;
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order findOrderById(Long id) {
        return orderRepository.findOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " not found"));
    }

    public List<Order> findUserOrders(String email) {
        return orderRepository.findAllByUserEmail(email);
    }

    public Order placeOrder(Purchase purchase, Long userId, Boolean saveNewShippingInfo) {
        if (purchase.getShippingInfo() == null) {
            throw new InvalidRequestException("Missing shipping information");
        }
        if (purchase.getOrderContentList() == null || purchase.getOrderContentList().isEmpty()) {
            throw new InvalidRequestException("Missing order content");
        }
        Order order = new Order(purchase.getShippingMethod(), purchase.getPaymentMethod(), LocalDateTime.now(), purchase.getShippingInfo());
        double total = 0.0;
        for (PurchaseContent purchaseContent : purchase.getOrderContentList()) {
            Long productId = purchaseContent.getProductId();
            String sizeTag = purchaseContent.getSize();
            Integer quantity = purchaseContent.getQuantity();
            Product product = productRepository.findProductById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException("Product with id " + productId + " not found"));
            Stock stock = stockRepository.findStockByProductIdAndSizeTag(productId, sizeTag)
                    .orElseThrow(() -> new ResourceNotFoundException("Product with id " + productId + " does not have a size " + sizeTag));
            if (quantity > stock.getQuantity())
                throw new InvalidRequestException(("Not enough products available in stock"));
            stockRepository.buyProducts(quantity, productId, sizeTag);
            Double price = product.getPrice();
            Double discount = product.getDiscount();
            if (discount != null)
                total += quantity * price * (1 - discount);
            else
                total += quantity * price;
            order.addOrderContent(new OrderContent(product, purchaseContent.getSize(), purchaseContent.getQuantity()));
        }
        order.setTotal(total);
        if (userId != null) {
            User user = userRepository.findUserById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));
            ShippingInfo shippingInfo = purchase.getShippingInfo();
            if (!user.getShippingInfoList().contains(shippingInfo)) {
                if (saveNewShippingInfo) {
                    user.getShippingInfoList().add(shippingInfo);
                }
            }
            user.setUserOrder(order);
            userRepository.save(user);
        }
        return orderRepository.save(order);
    }

    public Order updateOrder(Order order, Long id) {
        order.setId(id);
        if (order.getUser() == null) {
            User user = userRepository.findUserByOrderId(id);
            if (user != null) {
                order.setUser(user);
            }
        }
        if (order.getShippingInfo() == null) {
            ShippingInfo shippingInfo = shippingInfoRepository.findShippingInfoByOrderId(id);
            order.setShippingInfo(shippingInfo);
        }
        return orderRepository.save(order);
    }

    public Order updateOrderShipping(ShippingInfo shippingInfo, Long id) {
        Order order = orderRepository.findOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " not found"));
        order.setShippingInfo(shippingInfo);
        return orderRepository.save(order);
    }

    public Order updateOrderContent(OrderContent orderContent, Long id, Long contentId) {
        orderContent.setId(contentId);
        Order order = orderRepository.findOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " not found"));
        orderContent.setOrder(order);
        contentRepository.save(orderContent);
        return order;
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderRepository.deleteOrderById(id);
    }

    public void deleteProductFromOrder(Long id, Map<Long, String> productsWithSizes) {
        orderRepository.findOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " not found"));
        productsWithSizes.forEach((product, size) -> contentRepository.deleteContentFromOrder(id, product, size));
    }
}
