package com.ijse.coursework.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    
    private String name;
    private Double price;
    private Integer quantity;
    private Long categoryId;
}
