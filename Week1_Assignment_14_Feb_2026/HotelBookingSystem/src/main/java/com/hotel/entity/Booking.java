
package com.hotel.entity;

import javax.persistence.*;

@Entity
@Table(name="booking_details")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;

    @Column(nullable=false)
    private String customerName;

    private String roomType;
    private String checkInDate;
    private String checkOutDate;
    private double totalAmount;

    public Booking() {}

    public Booking(String customerName, String roomType,
                   String checkInDate, String checkOutDate, double totalAmount) {
        this.customerName = customerName;
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalAmount = totalAmount;
    }

    public int getBookingId() { return bookingId; }
    public String getCustomerName() { return customerName; }
    public String getRoomType() { return roomType; }
    public double getTotalAmount() { return totalAmount; }

    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setRoomType(String roomType) { this.roomType = roomType; }
}
