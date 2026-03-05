package org.capgemini;

import java.util.Scanner;
import org.capgemini.entity.Course;
import org.capgemini.entity.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        while (true) {

            System.out.println("\n1. Create Course");
            System.out.println("2. Add Student to Course");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            // 🔹 Case 1 - Create Course
            case 1:
                System.out.print("Enter Course Name: ");
                String courseName = sc.nextLine();

                Session session1 = factory.openSession();
                Transaction tx1 = session1.beginTransaction();

                Course course = new Course(courseName);
                session1.persist(course);

                tx1.commit();
                session1.close();

                System.out.println("Course Created!");
                break;

            // 🔹 Case 2 - Add Student to Existing Course
            case 2:
                System.out.print("Enter Course ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Student Name: ");
                String studentName = sc.nextLine();

                Session session2 = factory.openSession();
                Transaction tx2 = session2.beginTransaction();

                Course existingCourse = session2.get(Course.class, id);

                if (existingCourse != null) {

                    Student student = new Student(studentName);
                    student.addCourse(existingCourse);

                    session2.persist(student);

                    System.out.println("Student added to course!");

                } else {
                    System.out.println("Course not found!");
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
