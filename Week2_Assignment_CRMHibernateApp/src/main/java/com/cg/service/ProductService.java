package com.cg.service;

import com.cg.entity.Product;
import com.cg.util.JPAUtil;

import jakarta.persistence.*;

public class ProductService {

    public void addProduct(String name,
                           double price) {

        EntityManager em =
            JPAUtil.getEntityManager();

        EntityTransaction tx =
            em.getTransaction();

        try {
            tx.begin();

            Product product = new Product();
            product.setName(name);
            product.setPrice(price);

            em.persist(product);

            tx.commit();
            System.out.println("Product Added!");

        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}