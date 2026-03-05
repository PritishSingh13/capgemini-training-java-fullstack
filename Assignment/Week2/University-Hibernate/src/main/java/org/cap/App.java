package org.cap;

import java.util.*;
import org.cap.entity.Course;
import org.cap.entity.Department;
import org.cap.entity.Idcard;
import org.cap.entity.Student;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
		Configuration cfg = new Configuration().configure();
		SessionFactory factory = cfg.buildSessionFactory();

        while (true) {
            System.out.println("\n===== UNIVERSITY MANAGEMENT =====");
            System.out.println("1. Create Department");
            System.out.println("2. Create Course");
            System.out.println("3. Add Student");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:
                System.out.print("Enter Department Name: ");
                String deptName = sc.nextLine();

                Session session1 = factory.openSession();
                Transaction tx1 = session1.beginTransaction();

                Department dept = new Department();
                dept.setName(deptName);

                session1.persist(dept);

                tx1.commit();
                session1.close();

                System.out.println("Department Created");
                break;

            case 2:
                System.out.print("Enter Course Name: ");
                String courseName = sc.nextLine();

                Session session2 = factory.openSession();
                Transaction tx2 = session2.beginTransaction();

                Course course = new Course();
                course.setCourseName(courseName);

                session2.persist(course);

                tx2.commit();
                session2.close();

                System.out.println("Course Created!");
                break;

            case 3:

                Session session3 = factory.openSession();
                Transaction tx3 = session3.beginTransaction();

                System.out.print("Enter Student Name: ");
                String studentName = sc.nextLine();

                System.out.print("Enter Department ID: ");
                int deptId = sc.nextInt();
                sc.nextLine();

                Department existingDept = session3.get(Department.class, deptId);

                if (existingDept == null) {
                    System.out.println("Department not found!");
                    session3.close();
                    break;
                }

                Student student = new Student();
                student.setName(studentName);
                student.setDepartment(existingDept);

                existingDept.getStudents().add(student);

                System.out.print("Enter ID Card Number: ");
                String cardNumber = sc.nextLine();

                Idcard card = new Idcard();
                card.setCardNumber(cardNumber);

                student.setIdcard(card);
                card.setStudent(student);

                System.out.print("How many courses to enroll? ");
                int count = sc.nextInt();
                sc.nextLine();

                for (int i = 0; i < count; i++) {

                    System.out.print("Enter Course ID: ");
                    int courseId = sc.nextInt();
                    sc.nextLine();

                    Course existingCourse = session3.get(Course.class, courseId);

                    if (existingCourse != null) {
                        student.getCourses().add(existingCourse);
                        existingCourse.getStudents().add(student);
                    } else {
                        System.out.println("Course ID " + courseId + " not found!");
                    }
                }
                session3.persist(card);
                session3.persist(student);

                tx3.commit();
                session3.close();

                System.out.println("Student Added Successfully!");
                break;

            case 4:
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