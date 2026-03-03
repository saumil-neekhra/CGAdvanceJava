package com.cg.service;

import com.cg.entity.*;
import com.cg.util.JPAUtil;

import jakarta.persistence.*;

public class TicketService {

    public void raiseTicket(Long orderId,
                            String issueDescription) {

        EntityManager em =
            JPAUtil.getEntityManager();

        EntityTransaction tx =
            em.getTransaction();

        try {
            tx.begin();

            Order order =
                em.find(Order.class, orderId);

            if(order != null) {

                SupportTicket ticket =
                        new SupportTicket();

                ticket.setOrder(order);
                ticket.setIssueDescription(
                        issueDescription);

                em.persist(ticket);

                System.out.println(
                    "Support Ticket Raised!");
            }

            tx.commit();

        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}