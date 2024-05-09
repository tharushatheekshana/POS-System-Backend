package com.ijse.coursework.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddStockDto {
    private String name;
    private String description;
    private String category;
    private String quantity;
    private Double price;
}
