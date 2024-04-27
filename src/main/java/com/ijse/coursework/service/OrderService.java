package com.ijse.coursework.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.coursework.entity.Order;

@Service
public interface OrderService {

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order createOrder(Order order);

    Order updateOrder(Long id, Order order);

    Order addItemToOrder(Long id, Long productId, int quantity);

    Order removeItemFromOrder(Long orderId, Long itemId);

}
