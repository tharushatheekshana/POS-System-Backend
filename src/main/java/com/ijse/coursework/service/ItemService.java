package com.ijse.coursework.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.coursework.entity.Item;

@Service
public interface ItemService {

    List<Item> getAllItems();
    Item updateItem(Long id, Item item);
    void deleteItem(Long id);
    Item addItem(Item item);
    Item getItemById(Long id);

}
