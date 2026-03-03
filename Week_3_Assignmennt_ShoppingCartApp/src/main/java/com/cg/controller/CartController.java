package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.cg.model.Product;
import com.cg.service.CartService;
import com.cg.service.ProductService;

@Controller
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    // 1️⃣ Show Product List Page
    @GetMapping("/")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "products";
    }

    // 2️⃣ Add Product to Cart
    @PostMapping("/add")
    public String addToCart(@RequestParam int id,
                            @RequestParam int qty) {

        Product selectedProduct = productService.getProducts()
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (selectedProduct != null) {
            cartService.addToCart(selectedProduct, qty);
        }

        return "redirect:/cart";
    }

    // 3️⃣ View Cart Page
    @GetMapping("/cart")
    public String viewCart(Model model) {
        model.addAttribute("cartItems", cartService.getCartItems());
        model.addAttribute("total", cartService.getTotalAmount());
        return "cart";
    }
}