package com.cg.service;

import com.cg.entity.*;
import com.cg.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LeadService {
    public void createLead(String name,
            String source,
            String contactInfo) {

EntityManager em = JPAUtil.getEntityManager();
EntityTransaction tx = em.getTransaction();

try {
tx.begin();

Lead lead = new Lead();
lead.setName(name);
lead.setSource(source);
lead.setContactInfo(contactInfo);

em.persist(lead);

tx.commit();
System.out.println("Lead Created!");

} catch (Exception e) {
tx.rollback();
} finally {
em.close();
}
}
    public void assignLeadToEmployee(Long leadId,
            Long employeeId) {

EntityManager em = JPAUtil.getEntityManager();
EntityTransaction tx = em.getTransaction();

try {
tx.begin();

Lead lead =
em.find(Lead.class, leadId);

SalesEmployee emp =
em.find(SalesEmployee.class, employeeId);

if (lead != null && emp != null) {
lead.setEmployee(emp);
em.merge(lead);
System.out.println("Lead Assigned!");
}

tx.commit();

} catch (Exception e) {
tx.rollback();
} finally {
em.close();
}
}
    public void convertLeadToCustomer(Long leadId) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            Lead lead =
                em.find(Lead.class, leadId);

            if (lead != null) {

                Customer customer = new Customer();
                customer.setName(lead.getName());
                customer.setEmail(lead.getContactInfo());

                em.persist(customer);

                em.remove(lead);

                System.out.println(
                    "Lead Converted To Customer!");
            }

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        
    }
}
}
