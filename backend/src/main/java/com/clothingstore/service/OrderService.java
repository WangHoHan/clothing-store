package com.clothingstore.service;

import com.clothingstore.exception.InvalidRequestException;
import com.clothingstore.exception.ResourceNotFoundException;
import com.clothingstore.model.Order;
import com.clothingstore.model.OrderContent;
import com.clothingstore.model.ShippingInfo;
import com.clothingstore.model.User;
import com.clothingstore.repository.OrderContentRepository;
import com.clothingstore.repository.OrderRepository;
import com.clothingstore.repository.ShippingInfoRepository;
import com.clothingstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final ShippingInfoRepository shippingInfoRepository;

    private final OrderContentRepository contentRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserRepository userRepository, ShippingInfoRepository shippingInfoRepository, OrderContentRepository contentRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.shippingInfoRepository = shippingInfoRepository;
        this.contentRepository = contentRepository;
    }

    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    public Order findOrderById(Long id, String email) {
        return orderRepository.findOrderById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order with id " + id + " not found"));
    }

    public List<Order> findUserOrders(String email) {
        return orderRepository.findAllByUserEmail(email);
    }

    public Order placeOrder(Order order, Long userId, Boolean saveNewShippingInfo) {
        if (order.getShippingInfo() == null) {
            throw new InvalidRequestException("Missing shipping information");
        }
        if (order.getOrderContentList() == null || order.getOrderContentList().isEmpty()) {
            throw new InvalidRequestException("Missing order content");
        }
        if (userId != null) {
            User user = userRepository.findUserById(userId)
                    .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));
            ShippingInfo shippingInfo = order.getShippingInfo();
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
