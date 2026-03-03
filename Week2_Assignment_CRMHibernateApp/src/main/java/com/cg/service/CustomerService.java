package com.cg.service;

import com.cg.entity.Address;
import com.cg.entity.Customer;
import com.cg.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CustomerService {

    // ✅ Register Customer
    public void registerCustomer(String name,
                                 String email,
                                 String phone) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Customer customer = new Customer();
            customer.setName(name);
            customer.setEmail(email);
            customer.setPhone(phone);

            em.persist(customer);

            tx.commit();
            System.out.println("Customer Registered Successfully");

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    // ✅ Add Address
    public void addAddressToCustomer(Long customerId,
                                     Address address) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Customer customer =
                    em.find(Customer.class, customerId);

            if (customer != null) {

                customer.setAddress(address);

                em.merge(customer);

                System.out.println("Address Added");
            } else {
                System.out.println("Customer Not Found");
            }

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}