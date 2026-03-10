package com.assignment.studentcourseregistration.storage;

import com.assignment.studentcourseregistration.model.Course;
import com.assignment.studentcourseregistration.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStorage {

    public static Map<Integer, Student> students = new HashMap<>();

    public static Map<Integer, Course> courses = new HashMap<>();

    public static Map<Integer, List<Course>> enrollments = new HashMap<>();

}