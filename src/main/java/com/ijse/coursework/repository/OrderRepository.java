package com.ijse.coursework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.coursework.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
