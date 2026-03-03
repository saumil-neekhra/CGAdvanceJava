package com.cg.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.entity.Address;
import com.cg.service.CustomerService;
import com.cg.service.LeadService;
import com.cg.service.OrderService;
import com.cg.service.ProductService;
import com.cg.service.ReportService;
import com.cg.service.TicketService;

public class CRMApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CustomerService customerService =
                new CustomerService();
        LeadService leadService = new LeadService();
        ProductService productService =
                new ProductService();

        OrderService orderService =
                new OrderService();

        TicketService ticketService =
                new TicketService();

        ReportService reportService =
                new ReportService();

        while (true) {

        	System.out.println("\n===== CRM MENU =====");

        	System.out.println("1. Register Customer");
        	System.out.println("2. Add Address");
        	System.out.println("3. Create Lead");
        	System.out.println("4. Assign Lead");
        	System.out.println("5. Convert Lead");
        	System.out.println("6. Add Product");
        	System.out.println("7. Place Order");
        	System.out.println("8. Raise Ticket");
        	System.out.println("9. Employee Performance");
        	System.out.println("10. Exit");

            int choice = sc.nextInt();

            switch (choice) {

            case 1:
                sc.nextLine();

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                System.out.print("Phone: ");
                String phone = sc.nextLine();

                customerService
                .registerCustomer(name, email, phone);
                break;

            case 2:
                System.out.print("Customer ID: ");
                Long id = sc.nextLong();
                sc.nextLine();

                Address address = new Address();

                System.out.print("Street: ");
                address.setStreet(sc.nextLine());

                System.out.print("City: ");
                address.setCity(sc.nextLine());

                System.out.print("State: ");
                address.setState(sc.nextLine());

                System.out.print("Zip: ");
                address.setZipCode(sc.nextLine());

                customerService
                .addAddressToCustomer(id, address);
                break;
                
            case 3:
            	sc.nextLine();

            	System.out.print("Lead Name: ");
            	String lname = sc.nextLine();

            	System.out.print("Source: ");
            	String source = sc.nextLine();

            	System.out.print("Contact: ");
            	String contact = sc.nextLine();

            	leadService.createLead(lname, source, contact);
            	break;
            	
            case 4:
            	System.out.print("Lead ID: ");
            	Long lid = sc.nextLong();

            	System.out.print("Employee ID: ");
            	Long eid = sc.nextLong();

            	leadService.assignLeadToEmployee(lid, eid);
            	break;
            	
            case 5:
            	System.out.print("Lead ID: ");
            	Long cid = sc.nextLong();

            	leadService.convertLeadToCustomer(cid);
            	break;
            	
            case 6:
            	sc.nextLine();

            	System.out.print("Product Name: ");
            	String pname = sc.nextLine();

            	System.out.print("Price: ");
            	double price = sc.nextDouble();

            	productService.addProduct(pname, price);
            	break;
            	
            case 7:

            	System.out.print("Customer ID: ");
            	Long custId = sc.nextLong();

            	System.out.print("Number of Products: ");
            	int n = sc.nextInt();

            	List<Long> ids = new ArrayList<>();

            	for(int i=0;i<n;i++){
            	    ids.add(sc.nextLong());
            	}

            	orderService.placeOrder(custId, ids);
            	break;
            	
            case 8:

            	System.out.print("Order ID: ");
            	Long orderId = sc.nextLong();
            	sc.nextLine();

            	System.out.print("Issue: ");
            	String issue = sc.nextLine();

            	ticketService.raiseTicket(orderId, issue);
            	break;
            	
            case 9:

            	System.out.print("Employee ID: ");
            	Long empId = sc.nextLong();

            	reportService
            	.getEmployeePerformance(empId);
            	break;

            case 10:
                System.exit(0);
            }
        }
    }
}