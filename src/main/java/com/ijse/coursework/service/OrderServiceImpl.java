package com.ijse.coursework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.coursework.entity.Item;
import com.ijse.coursework.entity.Order;
import com.ijse.coursework.repository.ItemRepository;
import com.ijse.coursework.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();

    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order addItemToOrder(Long orderid, Long itemId, int quantity) {
        Order order = orderRepository.findById(orderid).orElse(null);

        if (order == null) {
            return null;
        }

        Item item = itemRepository.findById(itemId).orElse(null);

        if (item == null) {
            return null;
        }

        order.getOrderedItems().add(item);
        order.setTotalPrice(order.getTotalPrice() + item.getPrice());

        return orderRepository.save(order);
    }

    @Override
    public Order removeItemFromOrder(Long orderId, Long itemId) {
        Order order = orderRepository.findById(orderId).orElse(null);

        if (order == null) {
            return null;
        }

        Item item = itemRepository.findById(itemId).orElse(null);

        if (item == null) {
            return null;
        }

        order.getOrderedItems().remove(item);
        order.setTotalPrice(order.getTotalPrice() - item.getPrice());

        return orderRepository.save(order);
    }

}
