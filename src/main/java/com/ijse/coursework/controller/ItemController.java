package com.ijse.coursework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.coursework.dto.ItemDto;
import com.ijse.coursework.entity.Category;
import com.ijse.coursework.entity.Item;
import com.ijse.coursework.service.CategoryService;
import com.ijse.coursework.service.ItemService;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id) {
        Item item = itemService.getItemById(id);
        if (item == null) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(200).body(item);
        }
    }

    @PostMapping("/items")
    public ResponseEntity<Item> addItem(@RequestBody ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setSize(itemDto.getSize());
        item.setPrice(itemDto.getPrice());
        item.setQuantity(itemDto.getQuantity());

        Category category = categoryService.getCategoryById(itemDto.getCategoryId());
        item.setCategory(category);

        Item addItem = itemService.addItem(item);
        return ResponseEntity.status(201).body(addItem);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Object> updateItem(@PathVariable Long id, @RequestBody ItemDto itemdDto) {
        Item item = new Item();
        item.setName(itemdDto.getName());
        item.setSize(itemdDto.getSize());
        item.setPrice(itemdDto.getPrice());
        item.setQuantity(itemdDto.getQuantity());

        Category category = categoryService.getCategoryById(itemdDto.getCategoryId());
        item.setCategory(category);

        Item updateItem = itemService.updateItem(id, item);

        if (updateItem == null) {
            return ResponseEntity.status(404).build();

        } else {
            return ResponseEntity.status(200).body(updateItem);
        }
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
