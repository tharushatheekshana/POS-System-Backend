package com.ijse.coursework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.coursework.entity.StockCategory;
import com.ijse.coursework.repository.StockCategoryRepository;

@Service
public class StockCategoryServiceImpl implements StockCategoryService {

    @Autowired
    private StockCategoryRepository stockCategoryRepository;

    @Override
    public List<StockCategory> getAllStockCategories() {
        return stockCategoryRepository.findAll();
    }

    @Override
    public StockCategory getStockCategoryById(Long id) {
        return stockCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public StockCategory createStockCategory(StockCategory stockCategory) {
        return stockCategoryRepository.save(stockCategory);
    }

    @Override
    public void deleteStockCategory(Long id) {
        stockCategoryRepository.deleteById(id);
    }

    @Override
    public StockCategory updateStockCategory(Long id, StockCategory stockCategory) {
        StockCategory existingStockCategory = stockCategoryRepository.findById(id).orElse(null);
        if (existingStockCategory == null) {
            return null;
        }
        existingStockCategory.setName(stockCategory.getName());
        return stockCategoryRepository.save(existingStockCategory);
    }

}
