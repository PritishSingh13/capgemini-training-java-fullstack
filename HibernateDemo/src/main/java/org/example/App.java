package org.example;

import java.util.*;

import org.example.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	static SessionFactory factory;


    public static void main(String[] args) {

         factory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .buildSessionFactory();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1.to create student\n 2.to read\n 3. to update student \n 4. to delete student\n 5. to exit");
        System.out.println("Enter a choice: ");
        int choice = sc.nextInt();
        switch(choice) {
        case 1:
        	System.out.print("Enter name: ");
        	String name= sc.next();
        	System.out.print("Enter age: ");
        	int age = sc.nextInt();
        	createStudent(name, age);
        	break;
        case 2:
        	readStudent();
        	break;
        case 3:
        	System.out.println("1.to update name\n 2. to update Age\n 3. to update name and age ");
        	System.out.println("Enter Option: ");
        	int option = sc.nextInt();
        	System.out.println("");
        	System.out.println("Enter id: ");
        	int id = sc.nextInt();
        	switch(option) {
        	case 1:
            	System.out.println("Enter New name: ");
            	String newName= sc.next();
            	updateName(id, newName);
            	break;
        	case 2:
        		System.out.println("Enter new Age: ");
        		int newAge = sc.nextInt();
        		updateAge(id, newAge);
        		break;
        	case 3:
            	System.out.println("Enter New name: ");
            	String newName1= sc.next();
        		System.out.println("Enter new Age: ");
        		int newAge1 = sc.nextInt();
        		updateStudent(id, newName1, newAge1);
        		break;
        	default:
        		System.out.println("Invalid Input!");
        	}
        	break;
        case 4:
        	System.out.println("Enter id: ");
        	int id1 = sc.nextInt();
        	deleteStudent(id1);
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


    public static void createStudent(String name,int age) {

        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        Student student = new Student(name,age);
        

        session.persist(student);

        t.commit();

        session.close();

        System.out.println("Student "+name+" inserted successfully!");
    }
    public static void readStudent() {

    	Session session  = factory.openSession();
    	session.createQuery("from Student",Student.class).stream().forEach(System.out::println);
   
     	System.out.println("Read the student");

    	session.close();
    }
    public static void updateName(int id,String newName) {
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	Student s = session.get(Student.class,id);
   if(s != null) {
	   s.setName(newName);
	   t.commit();
	   System.out.println("Name updated");
   }else {
	   System.out.println("student not found");
	   t.rollback();
   }
   session.close();
    }
    public static void updateAge(int id,int newAge) {
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction();
    	Student s = session.get(Student.class, id);
    	if(s!=null) {
    		s.setAge(newAge);
    		t.commit();
    		System.out.println("Age updated");
    		
    	}
    	else {
    		System.out.println("Student not found");
    		t.rollback();
    	}
    	session.close();
    }
    public static void updateStudent(int  id,String newName,int newAge) {
    	Session session = factory.openSession();
    	Transaction t = session.beginTransaction();
    	
    	Student s = session.get(Student.class,id);
    	if(s!= null) {
    		s.setName(newName);
    		s.setAge(newAge);
    		t.commit();
    		System.out.println("Updated student id: "+id);
    	}else {
    		System.out.println("Student not found");
    		t.rollback();
    	}
    	session.close();
    }
   public static void deleteStudent(int id) {
	   Session session = factory.openSession();
	   Transaction t = session.beginTransaction();
	   Student s= session.get(Student.class, id);
	   if(session != null) {
		   session.remove(s);
		   t.commit();
		   System.out.println("Deleted student id: "+id);
	   }else {
		   System.out.println("Student not found");
		   t.rollback();
	   }
	   session.close();
   }
}
