package com.ijse.coursework.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ijse.coursework.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
