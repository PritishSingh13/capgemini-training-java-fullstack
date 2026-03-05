package org.capgemini;

import org.hibernate.cfg.Configuration;
import java.util.*;

import org.capgemini.entity.Passport;
import org.capgemini.entity.Person;
import org.hibernate.*;


public class App {
	public static void main(String[] args) {
		Scanner  sc= new Scanner(System.in);
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		while(true) {
			System.out.println("\n 1.Add Person & Passport. \n 2. Exit");
			System.out.print("Enter a Choice: ");
			int choice = sc.nextInt();
			sc.nextLine();
			 switch(choice) {
			 case 1:
				 System.out.print("Enter person name: ");
				 String name = sc.nextLine();
				 System.out.print("Enter passport number: ");
				 String passportNumber = sc.nextLine();
				 System.out.print("Enter country: ");
				 String country = sc.nextLine();
				 
				 
				 Session session = factory.openSession();
				 Transaction tx = session.beginTransaction();
				 Passport passport = new Passport(passportNumber,country);
				 Person person = new Person(name,passport);
				 
				 session.persist(person);
				 tx.commit();
				 session.close();
				 System.out.println();
				 System.out.println("Person and Passport saved successfully");
				 break;
			 case 2:
				 factory.close();
				 sc.close();
				 System.out.println("Exiting....");
				 return;
			default:
				System.out.println("Invalid choice....");
			
				 
			 }
		}
		
		
		
		
	}
}
