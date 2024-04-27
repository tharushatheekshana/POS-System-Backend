package com.ijse.coursework.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.coursework.entity.*;

@Service
public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category createCategory(Category category);

    void deleteCategory(Long id);

}
