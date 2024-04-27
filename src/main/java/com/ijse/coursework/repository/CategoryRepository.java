package com.ijse.coursework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ijse.coursework.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
