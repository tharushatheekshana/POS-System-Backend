package com.ijse.coursework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.coursework.entity.Item;
import com.ijse.coursework.entity.Order;
import com.ijse.coursework.entity.OrderItem;
import com.ijse.coursework.repository.ItemRepository;
import com.ijse.coursework.repository.OrderItemRepository;
import com.ijse.coursework.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

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
    public Order removeItemFromOrder(Long orderId, Long itemId) {
        Order order = orderRepository.findById(orderId).orElse(null);

        if (order == null) {
            return null;
        }

        Item item = itemRepository.findById(itemId).orElse(null);

        if (item == null) {
            return null;
        }

        List<OrderItem> orderItems = orderItemRepository.findByOrderIdAndItemId(orderId, itemId);

        if (orderItems.isEmpty()) {
            return null;
        }

        // handle multiple OrderItems, for example, by merging them or picking the first
        // one
        OrderItem orderItem = orderItems.get(0);

        order.setTotalPrice(order.getTotalPrice() - (item.getPrice() * orderItem.getQuantity()));
        orderItemRepository.delete(orderItem);

        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order == null) {
            return;
        }

        List<OrderItem> orderItems = orderItemRepository.findByOrderId(order.getId());
        orderItemRepository.deleteAll(orderItems);
        orderRepository.delete(order);

    }

    @Override
    public Order addItemToOrder(Long orderId, Long itemId, Integer quantity) {

        Order order = orderRepository.findById(orderId).orElse(null);

        if (order == null) {
            return null;
        }

        Item item = itemRepository.findById(itemId).orElse(null);

        if (item == null) {
            return null;
        }

        OrderItem existingOrderItem = orderItemRepository.findByOrderIdAndItemId(orderId, itemId).stream().findFirst()
                .orElse(null);

        // if (existingOrderItem != null) {
        // Integer newQty = quantity + (existingOrderItem.getQuantity());
        // existingOrderItem.setQuantity(newQty);
        // order.setTotalPrice(order.getTotalPrice() + (item.getPrice() * newQty));
        // return orderRepository.save(order);
        // }

        if (existingOrderItem != null) {
            Integer newQty = quantity + existingOrderItem.getQuantity();
            // Subtract the price of the existing order item from the total price
            order.setTotalPrice(order.getTotalPrice() - (item.getPrice() * existingOrderItem.getQuantity()));
            existingOrderItem.setQuantity(newQty);
            // Add the price of the updated order item to the total price
            order.setTotalPrice(order.getTotalPrice() + (item.getPrice() * newQty));
            return orderRepository.save(order);
        }

        // Item does not exist, create a new order item
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setQuantity(quantity);
        orderItem.setOrder(order);
        order.getOrderItems().add(orderItem);
        order.setTotalPrice(order.getTotalPrice() + (item.getPrice() * quantity));
        orderItemRepository.save(orderItem);

        return orderRepository.save(order);
    }

    @Override
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
