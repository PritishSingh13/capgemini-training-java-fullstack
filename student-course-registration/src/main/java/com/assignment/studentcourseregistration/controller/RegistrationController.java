package com.assignment.studentcourseregistration.controller;

import com.assignment.studentcourseregistration.model.Course;
import com.assignment.studentcourseregistration.model.Student;
import com.assignment.studentcourseregistration.service.RegistrationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RegistrationController {

    private final RegistrationService service;

    public RegistrationController(RegistrationService service){
        this.service = service;
    }

    @PostMapping("/students")
    public String createStudent(@RequestBody Student student){

        return service.addStudent(student);
    }

    @PostMapping("/courses")
    public String createCourse(@RequestBody Course course){

        return service.addCourse(course);
    }

    @PostMapping("/enroll/{studentId}/{courseId}")
    public String enrollStudent(@PathVariable Integer studentId,
                                @PathVariable Integer courseId){

        return service.enrollStudent(studentId,courseId);
    }

    @GetMapping("/students/{id}/courses")
    public List<Course> getCourses(@PathVariable Integer id){

        return service.getStudentCourses(id);
    }

    @DeleteMapping("/enroll/{studentId}/{courseId}")
    public String removeEnrollment(@PathVariable Integer studentId,
                                   @PathVariable Integer courseId){

        return service.removeEnrollment(studentId,courseId);
    }

}