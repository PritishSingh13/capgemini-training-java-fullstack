package org.capgemini.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();

    public Student() {}

    public Student(String name) {
        this.name = name;
    }

    // 🔥 Important: prevent duplicate manually
    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.getStudents().add(this);
        }
    }

    public List<Course> getCourses() {
        return courses;
    }

    public String getName() {
        return name;
    }
}
