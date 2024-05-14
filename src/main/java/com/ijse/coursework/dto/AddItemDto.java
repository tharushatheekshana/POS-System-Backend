package com.ijse.coursework.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddItemDto {
    private Long itemId;
    private Integer quantity;
    private Long TableNo;
    private Integer orderComplete;
}
