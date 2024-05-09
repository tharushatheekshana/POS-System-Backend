package com.ijse.coursework.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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

    @Autowired
    private Environment environment;

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
    public ResponseEntity<Item> addItem(@ModelAttribute ItemDto itemDto, @RequestParam("file") MultipartFile file)
            throws IOException {
        Category category = categoryService.getCategoryById(itemDto.getCategoryId());
        String uploadDirectory = environment.getProperty("image.upload.directory");

        String fileName = file.getOriginalFilename();
        Path filePath = Paths.get(uploadDirectory, file.getOriginalFilename());
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        String imagePath = filePath.toString();

        Item item = new Item();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setDescription(itemDto.getDescription());
        // item.setQuantity(itemDto.getQuantity());
        item.setImage(fileName);

        item.setCategory(category);

        Item addItem = itemService.addItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(addItem);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable Long id, @ModelAttribute ItemDto itemDto,
            @RequestParam(value = "file", required = false) MultipartFile file) throws IOException {
        Item existingItem = itemService.getItemById(id);
        if (existingItem == null) {
            return ResponseEntity.notFound().build();
        }

        existingItem.setName(itemDto.getName());
        existingItem.setPrice(itemDto.getPrice());
        existingItem.setDescription(itemDto.getDescription());

        Category category = categoryService.getCategoryById(itemDto.getCategoryId());
        existingItem.setCategory(category);

        if (file != null && !file.isEmpty()) {
            String uploadDirectory = environment.getProperty("image.upload.directory");
            String fileName = file.getOriginalFilename();
            Path filePath = Paths.get(uploadDirectory, fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            String imagePath = filePath.toString();
            existingItem.setImage(fileName);
        }

        Item updatedItem = itemService.updateItem(id, existingItem);

        if (updatedItem == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedItem);
        }
    }

    @DeleteMapping("/items/{id}")
    public void deleteItem(@PathVariable Long id) {
        Item item = itemService.getItemById(id);

        // Delete associated image file
        String uploadDirectory = environment.getProperty("image.upload.directory");
        String imagePath = uploadDirectory + "/" + item.getImage();
        Path imageFilePath = Paths.get(imagePath);
        try {
            Files.deleteIfExists(imageFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        itemService.deleteItem(id);

    }

}
