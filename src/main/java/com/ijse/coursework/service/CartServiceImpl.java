package com.ijse.coursework.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.coursework.entity.Cart;
import com.ijse.coursework.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public List<Cart> getAllCartItems() {
        return cartRepository.findAll();
    }

    @Override
    public Cart getCartItemById(Long id) {
        return cartRepository.findById(id).orElse(null);
    }

    @Override
    public Cart addCartItem(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteCartItem(Long id) {
        cartRepository.deleteById(id);
    }

    @Override
    public void deleteAllCartItems() {
        cartRepository.deleteAll();
    }

    @Override
    public Cart updateCartItem(Long id, Cart existingCart) {
        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart == null) {
            return null;
        }
        cart.setQuantity(existingCart.getQuantity());
        return cartRepository.save(cart);
    }

}
