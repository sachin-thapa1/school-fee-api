package com.sachin.school_fee_api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.school_fee_api.entity.Student;
import com.sachin.school_fee_api.services.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service){
        this.service = service;
    }

    @PostMapping
    public Student create(@RequestBody Student student){
        System.out.println(">>> received student = " + student);
        Student saved = service.saveStudent(student);
        System.out.println(">>> returning student = "+ saved);
        return saved;
    }

}
