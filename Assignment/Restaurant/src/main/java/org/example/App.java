package org.example;

import org.example.entity.MenuItem;

import java.util.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class App {
	static SessionFactory factory;


    public static void main(String[] args) {

         factory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1.Add Item \n 2.View all items\n 3. to update price \n 4. to delete item\n 5. to exit");
        System.out.println("Enter a choice: ");
        int choice = sc.nextInt();
        sc.nextLine();
        switch(choice) {
        case 1:
        	System.out.println("Enter item name: ");
        	String name= sc.nextLine();
        	System.out.println("Enter price: ");
        	int price = sc.nextInt();
        	AddItem(name,price);
        	break;
        case 2:
        	readItems();
        	break;
        case 3:
        	System.out.println("Enter id: ");
        	int id = sc.nextInt();
        	System.out.println("Enter new price: ");
        	int newprice= sc.nextInt(); 
            	updatePrice(id,newprice);
            	break;
        case 4:
        	System.out.println("Enter id: ");
        	int id1 = sc.nextInt();
        	deleteItem(id1);
        	break;
        case 5:
            factory.close();
            System.out.println("Exited successfully!");
            System.exit(0);
            break;
        default:
        	System.out.println("Invalid!");	
        }
        factory.close();
    }

    public static void AddItem(String name, int price) {

        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        MenuItem item = new MenuItem(name, price);

        session.persist(item);

        t.commit();
        session.close();

        System.out.println("Item inserted successfully!");
    }

    public static void readItems() {

        Session session = factory.openSession();

        session.createQuery("from MenuItem", MenuItem.class).stream().forEach(System.out::println);

        session.close();
    }
    public static void updatePrice(int id,int newPrice) {

        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        MenuItem item = session.get(MenuItem.class, id);

        if (item != null) {
            item.setPrice(newPrice);
            t.commit();
            System.out.println("Price updated successfully!");
        } else {
            System.out.println("Item not found!");
            t.rollback();
        }

        session.close();
    }

    public static void deleteItem(int id) {

        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        MenuItem item = session.get(MenuItem.class, id);

        if (item != null) {
            session.remove(item);
            t.commit();
            System.out.println("Item deleted successfully!");
        } else {
            System.out.println("Item not found!");
            t.rollback();
        }

        session.close();
    }
}
