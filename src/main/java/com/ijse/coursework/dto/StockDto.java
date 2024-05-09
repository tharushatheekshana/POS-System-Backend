package com.ijse.coursework.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDto {
    private Long id;
    private String name;
    private String description;
    private String quantity;
    private Long stockCategoryId;

}
