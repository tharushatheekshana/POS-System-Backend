package com.ijse.coursework.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.coursework.entity.StockCategory;

@Repository
public interface StockCategoryRepository extends JpaRepository<StockCategory, Long> {
}
