package com.cg.service;

import com.cg.util.JPAUtil;

import jakarta.persistence.*;

public class ReportService {

    public void getEmployeePerformance(
                                Long employeeId) {

        EntityManager em =
            JPAUtil.getEntityManager();

        try {

            String jpql =
            "SELECT COUNT(l) FROM Lead l "
          + "WHERE l.employee.id = :eid";

            Long count =
                em.createQuery(jpql, Long.class)
                .setParameter("eid", employeeId)
                .getSingleResult();

            System.out.println(
            "Total Leads Handled: " + count);

        } finally {
            em.close();
        }
    }
}