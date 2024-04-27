package com.ijse.coursework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.coursework.entity.Category;
import com.ijse.coursework.service.CategoryService;

@RestController
@CrossOrigin(origins = "*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories") // static routing path
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{id}") // dynamic routing path with ID
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/categories/{id}") // delete category
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }

}