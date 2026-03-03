package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.model.CartItem;
import com.cg.model.Product;

@Service
public class CartService {

    private List<CartItem> cart = new ArrayList<>();

    // Add product to cart
    public void addToCart(Product product, int quantity) {
        cart.add(new CartItem(product, quantity));
    }

    // Get cart items
    public List<CartItem> getCartItems() {
        return cart;
    }

    // Calculate total amount
    public double getTotalAmount() {
        double total = 0;
        for (CartItem item : cart) {
            total += item.getTotal();
        }
        return total;
    }
}