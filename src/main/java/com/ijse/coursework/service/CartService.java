package com.ijse.coursework.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.coursework.entity.Cart;

@Service
public interface CartService {

    List<Cart> getAllCartItems();

    Cart getCartItemById(Long id);

    Cart addCartItem(Cart cart);

    void deleteCartItem(Long id);

    void deleteAllCartItems();

    Cart updateCartItem(Long id, Cart existingCart);

}
