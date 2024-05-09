package com.ijse.coursework.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.coursework.entity.Stock;
import com.ijse.coursework.entity.StockCategory;

@Service
public interface StockService {

    List<Stock> getAllStocks();

    Stock updateStock(Long id, Stock stock);

    void deleteStock(Long id);

    Stock addStock(Stock stock);

    Stock getStockById(Long id);

}
