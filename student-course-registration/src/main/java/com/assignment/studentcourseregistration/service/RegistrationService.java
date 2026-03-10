package com.assignment.studentcourseregistration.service;

import com.assignment.studentcourseregistration.model.Course;
import com.assignment.studentcourseregistration.model.Student;
import com.assignment.studentcourseregistration.storage.DataStorage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService {

    public String addStudent(Student student){

        DataStorage.students.put(student.getId(), student);

        return "Student added successfully";
    }

    public String addCourse(Course course){

        DataStorage.courses.put(course.getId(), course);

        return "Course added successfully";
    }

    public String enrollStudent(Integer studentId, Integer courseId){

        Student student = DataStorage.students.get(studentId);
        Course course = DataStorage.courses.get(courseId);

        if(student == null || course == null){
            return "Student or Course not found";
        }

        List<Course> courseList =
                DataStorage.enrollments.getOrDefault(studentId, new ArrayList<>());

        courseList.add(course);

        DataStorage.enrollments.put(studentId, courseList);

        return "Student enrolled successfully";
    }

    public List<Course> getStudentCourses(Integer studentId){

        return DataStorage.enrollments.getOrDefault(studentId,new ArrayList<>());
    }

    public String removeEnrollment(Integer studentId, Integer courseId){

        List<Course> courseList = DataStorage.enrollments.get(studentId);

        if(courseList == null){
            return "No enrollment found";
        }

        courseList.removeIf(course -> course.getId().equals(courseId));

        return "Enrollment removed successfully";
    }

}