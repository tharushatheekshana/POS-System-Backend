package com.ijse.coursework.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDto {
    private Long id;
    private String name;
    private double price;
    private int quantity;
    private String image;
    private Double totalPrice;
}
