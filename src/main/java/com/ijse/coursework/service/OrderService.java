package com.ijse.coursework.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.coursework.entity.Order;
import com.ijse.coursework.entity.OrderItem;

@Service
public interface OrderService {

    List<Order> getAllOrders();

    Order getOrderById(Long id);

    Order updateOrder(Long id, Order order);

    Order removeItemFromOrder(Long orderId, Long itemId);

    void deleteOrder(Long id);

    Order createOrder(Order order);

    Order addItemToOrder(Long id, Long itemId, Integer quantity);

    OrderItem getOrderItemById(Long id);

    OrderItem updateOrderItem(OrderItem orderItem);

}
