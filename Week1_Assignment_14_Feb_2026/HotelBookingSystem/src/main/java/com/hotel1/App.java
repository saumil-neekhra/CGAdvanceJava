
package com.hotel1;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import com.hotel.entity.Booking;

public class App {

    public static void main(String[] args) {

        SessionFactory factory =
                new Configuration().configure().buildSessionFactory();

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        Booking b = new Booking(
                "Akhilesh",
                "Deluxe",
                "2026-02-14",
                "2026-02-16",
                7000
        );

        session.save(b);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("Booking inserted");
    }
}