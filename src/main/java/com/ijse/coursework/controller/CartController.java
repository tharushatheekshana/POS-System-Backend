package com.ijse.coursework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.coursework.dto.CartDto;
import com.ijse.coursework.entity.Cart;
import com.ijse.coursework.service.CartService;

@RestController
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public List<Cart> getAllCartItems() {
        return cartService.getAllCartItems();
    }

    @GetMapping("/cart/{id}")
    public Cart getCartItemById(@PathVariable Long id) {
        return cartService.getCartItemById(id);
    }

    @PostMapping("/cart")
    public ResponseEntity<Cart> addCartItem(@RequestBody CartDto cartDto) {
        Cart cart = new Cart();
        cart.setQuantity(cartDto.getQuantity());
        cart.setPrice(cartDto.getPrice());
        cart.setName(cartDto.getName());
        cart.setImage(cartDto.getImage());

        Cart addCartItem = cartService.addCartItem(cart);
        return ResponseEntity.status(201).body(addCartItem);
    }

    @PutMapping("/cart/{id}")
    public ResponseEntity<Cart> updateCartItem(@PathVariable Long id, @RequestBody CartDto cartDto) {

        Cart existingCart = cartService.getCartItemById(id);

        if (existingCart == null) {
            return ResponseEntity.status(404).build();
        }

        existingCart.setQuantity(cartDto.getQuantity());

        Cart updatedCart = cartService.updateCartItem(id, existingCart);

        if (updatedCart == null) {
            return ResponseEntity.status(500).build();
        } else {
            return ResponseEntity.status(200).body(updatedCart);
        }
    }

    @DeleteMapping("/cart/{id}")
    public void deleteCartItem(@PathVariable Long id) {
        cartService.deleteCartItem(id);
    }

    @DeleteMapping("/cart")
    public void deleteAllCartItems() {
        cartService.deleteAllCartItems();
    }

}
