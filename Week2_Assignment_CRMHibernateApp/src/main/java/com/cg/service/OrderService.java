package com.cg.service;

import com.cg.entity.*;
import com.cg.util.JPAUtil;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.*;

public class OrderService {

    public void placeOrder(Long customerId,
                           List<Long> productIds) {

        EntityManager em =
            JPAUtil.getEntityManager();

        EntityTransaction tx =
            em.getTransaction();

        try {
            tx.begin();

            Customer customer =
                em.find(Customer.class,
                        customerId);

            List<Product> products =
                new ArrayList<>();

            double total = 0;

            for(Long id : productIds) {

                Product p =
                    em.find(Product.class,id);

                if(p!=null){
                    products.add(p);
                    total += p.getPrice();
                }
            }

            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            order.setOrderDate(LocalDate.now());
            order.setTotalAmount(total);

            em.persist(order);

            tx.commit();

            System.out.println(
                "Order Placed Successfully!");

        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}