package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.model.Product;

@Service
public class ProductService {

    public List<Product> getProducts() {

        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Laptop", 50000));
        products.add(new Product(2, "Mobile", 20000));
        products.add(new Product(3, "Headphones", 2000));
        products.add(new Product(4, "Keyboard", 1500));

        return products;
    }
}