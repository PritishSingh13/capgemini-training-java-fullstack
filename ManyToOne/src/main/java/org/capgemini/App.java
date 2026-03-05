package org.capgemini;

import java.util.Scanner;
import org.capgemini.entity.Department;
import org.capgemini.entity.Employee;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        while (true) {

            System.out.println("\n1. Create Department");
            System.out.println("2. Add Employee to Department");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:
                System.out.print("Enter Department Name: ");
                String deptName = sc.nextLine();

                Session session1 = factory.openSession();
                Transaction tx1 = session1.beginTransaction();

                Department dept = new Department(deptName);
                session1.persist(dept);

                tx1.commit();
                session1.close();

                System.out.println("Department Created!");
                break;

            case 2:
                System.out.print("Enter Department ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Employee Name: ");
                String empName = sc.nextLine();

                Session session2 = factory.openSession();
                Transaction tx2 = session2.beginTransaction();

                Department existingDept = session2.get(Department.class, id);

                if (existingDept != null) {

                    Employee emp = new Employee(empName, existingDept);
                    session2.persist(emp);

                    System.out.println("Employee added to department!");

                } else {
                    System.out.println("Department not found!");
                }

                tx2.commit();
                session2.close();
                break;

            }
        }
    }
}
