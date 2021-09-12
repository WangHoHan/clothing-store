package com.clothingstore.controller;

import com.clothingstore.model.Order;
import com.clothingstore.model.OrderContent;
import com.clothingstore.model.ShippingInfo;
import com.clothingstore.model.purchase.Purchase;
import com.clothingstore.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.findAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("authentication.principal.equals(#email) and hasAuthority('ROLE_CUSTOMER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<Order> getOrderById(@PathVariable("id") Long id,
                                              @RequestParam(required = false) String email) {
        Order order = orderService.findOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping("/user/{email}")
    @PreAuthorize("authentication.principal.equals(#email) and hasAuthority('ROLE_CUSTOMER') or hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable("email") String email) {
        List<Order> orders = orderService.findUserOrders(email);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Order> placeOrder(@RequestBody Purchase order,
                                            @RequestParam(required = false) Long userId,
                                            @RequestParam(required = false) Boolean saveNewShippingInfo) {
        Order newOrder = orderService.placeOrder(order, userId, saveNewShippingInfo);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order,
                                             @PathVariable("id") Long id) {
        Order updatedOrder = orderService.updateOrder(order, id);
        return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
    }

    @PutMapping("/{id}/shipping")
    public ResponseEntity<Order> updateOrderShipping(@RequestBody ShippingInfo shippingInfo,
                                                     @PathVariable("id") Long id) {
        Order order = orderService.updateOrderShipping(shippingInfo, id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PutMapping("/{id}/content/{contentId}")
    public ResponseEntity<Order> updateOrderContent(@RequestBody OrderContent orderContent,
                                                    @PathVariable("id") Long id,
                                                    @PathVariable("contentId") Long contentId) {
        Order order = orderService.updateOrderContent(orderContent, id, contentId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}/content")
    public ResponseEntity<?> deleteProductFromOrder(@PathVariable("id") Long id,
                                                    @RequestParam Map<Long, String> productsWithSizes) {
        orderService.deleteProductFromOrder(id, productsWithSizes);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
