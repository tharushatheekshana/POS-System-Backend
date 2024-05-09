package com.ijse.coursework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.coursework.entity.Item;
import com.ijse.coursework.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();

    }

    @Override
    public Item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    @Override
    public Item updateItem(Long id, Item item) {
        Item existItem = itemRepository.findById(id).orElse(null);

        if (existItem == null) {
            return null;
        }
        existItem.setName(item.getName());
        existItem.setPrice(item.getPrice());
        existItem.setDescription(item.getDescription());
        // existItem.setQuantity(item.getQuantity());

        return itemRepository.save(existItem);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getItemsByCategory(Long id) {
        return itemRepository.findByCategoryId(id);
    }

}
