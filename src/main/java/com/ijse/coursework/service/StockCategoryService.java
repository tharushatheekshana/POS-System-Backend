package com.ijse.coursework.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.coursework.entity.Category;
import com.ijse.coursework.entity.StockCategory;

@Service
public interface StockCategoryService {

    List<StockCategory> getAllStockCategories();

    StockCategory getStockCategoryById(Long id);

    StockCategory createStockCategory(StockCategory stockCategory);

    void deleteStockCategory(Long id);

    StockCategory updateStockCategory(Long id, StockCategory stockCategory);

}
