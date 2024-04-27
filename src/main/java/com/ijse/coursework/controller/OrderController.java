package com.ijse.coursework.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.coursework.dto.OrderItemDto;
import com.ijse.coursework.entity.Order;
import com.ijse.coursework.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    public Order createOrder() {
        Order order = new Order();

        order.setTotalPrice(0.0);
        order.setOrderDate(LocalDateTime.now());
        order.setOrderedItems(null);

        return orderService.createOrder(order);
    }

    @PutMapping("/orders/{id}")
    public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
        return orderService.updateOrder(id, order);
    }

    @PostMapping("/orders/{id}/addItem")
    public Order addProductToOrder(@PathVariable Long id, @RequestBody OrderItemDto orderProductDto) {
        return orderService.addItemToOrder(id, orderProductDto.getProductId(), orderProductDto.getQuantity());
    }

    @DeleteMapping("/orders/{orderId}/item/{itemId}")
    public Order removeItemFromOrder(@PathVariable Long orderId, @PathVariable Long itemId) {
        return orderService.removeItemFromOrder(orderId, itemId);
    }

}
