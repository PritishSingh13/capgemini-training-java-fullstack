package org.capgemini;

import org.hibernate.cfg.Configuration;
import java.util.*;

import org.capgemini.entity.Customer;
import org.capgemini.entity.Order;
import org.hibernate.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Configuration cfg = new Configuration().configure();
        SessionFactory factory = cfg.buildSessionFactory();

        while (true) {

            System.out.println("\n1. Create Customer");
            System.out.println("2. Add Order to Existing Customer");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:
                System.out.print("Enter Customer Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Order Date: ");
                String orderDate1 = sc.nextLine();

                Session session1 = factory.openSession();
                Transaction tx1 = session1.beginTransaction();

                Customer customer = new Customer(name);

                Order order = new Order();
                order.setOrderDate(orderDate1);
                customer.addOrder(order);

                session1.persist(customer);  // cascade saves order

                tx1.commit();
                session1.close();

                System.out.println("Customer and first order created successfully!");
                break;


            case 2:
                System.out.print("Enter Customer ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Order Date: ");
                String orderDate = sc.nextLine();

                Session session2 = factory.openSession();
                Transaction tx2 = session2.beginTransaction();

                Customer existingCustomer = session2.get(Customer.class, id);

                if (existingCustomer != null) {
                	Order order1 = new Order();
                	order1.setOrderDate(orderDate);

                	existingCustomer.addOrder(order1);   // 🔥 cleaner way

                	session2.persist(order1);

                    System.out.println("Order Added Successfully!");

                } else {
                    System.out.println("Customer not found!");
                }

                tx2.commit();
                session2.close();
                break;


            case 3:
                factory.close();
                sc.close();
                System.out.println("Exiting...");
                return;

            default:
                System.out.println("Invalid choice!");
            }
        }
    }
}
