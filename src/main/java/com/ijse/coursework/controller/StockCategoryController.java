package com.ijse.coursework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.coursework.entity.StockCategory;
import com.ijse.coursework.service.StockCategoryService;

@RestController
@CrossOrigin(origins = "*")
public class StockCategoryController {

    @Autowired
    private StockCategoryService stockCategoryService;

    @GetMapping("/stockcategories")
    public List<StockCategory> getAllStockCategories() {
        return stockCategoryService.getAllStockCategories();
    }

    @GetMapping("/stockcategories/{id}")
    public StockCategory getStockCategoryById(@PathVariable Long id) {
        return stockCategoryService.getStockCategoryById(id);
    }

    @PostMapping("/stockcategories")
    public StockCategory createStockCategory(@RequestBody StockCategory stockCategory) {
        return stockCategoryService.createStockCategory(stockCategory);
    }

    @DeleteMapping("/stockcategories/{id}")
    public void deleteStockCategory(@PathVariable Long id) {
        stockCategoryService.deleteStockCategory(id);
    }

    @PutMapping("/stockcategories/{id}")
    public StockCategory updateStockCategory(@PathVariable Long id, @RequestBody StockCategory stockCategory) {
        return stockCategoryService.updateStockCategory(id, stockCategory);
    }

}
