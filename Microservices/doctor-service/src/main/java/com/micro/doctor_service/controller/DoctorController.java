package com.micro.doctor_service.controller;

import com.micro.doctorservice.model.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @GetMapping
    public List<Doctor> getDoctors() {

        return Arrays.asList(
                new Doctor(1, "Dr Sharma", "Cardiologist"),
                new Doctor(2, "Dr Mehta", "Dentist")
        );
    }
}