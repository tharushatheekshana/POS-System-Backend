package com.ijse.coursework.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.coursework.dto.AddItemDto;
import com.ijse.coursework.entity.Order;
import com.ijse.coursework.entity.OrderItem;
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
    public Order createOrder(@RequestBody AddItemDto addItemDto) {
        Order order = new Order();

        order.setTotalPrice(0.0);
        order.setOrderDate(LocalDateTime.now());
        // order.setOrderedItems(null);
        order.setTableNo(addItemDto.getTableNo());

        return orderService.createOrder(order);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<OrderItem> updateOrder(@PathVariable Long id, @RequestBody AddItemDto addItemDto) {
        Order order = orderService.getOrderById(id);

        if (order == null) {
            return ResponseEntity.status(404).build();
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(addItemDto.getQuantity());

        order.setOrderComplete(addItemDto.getOrderComplete());

        OrderItem updatedOrderItem = orderService.updateOrderItem(orderItem);

        return ResponseEntity.status(200).body(updatedOrderItem);
    }

    @PostMapping("/orders/{id}/addItem")
    public Order addItemToOrder(@PathVariable Long id, @RequestBody AddItemDto AddItemDto) {
        return orderService.addItemToOrder(id, AddItemDto.getItemId(), AddItemDto.getQuantity());
    }

    @DeleteMapping("/orders/{orderId}/item/{itemId}")
    public Order removeItemFromOrder(@PathVariable Long orderId, @PathVariable Long itemId) {
        return orderService.removeItemFromOrder(orderId, itemId);
    }

    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}
