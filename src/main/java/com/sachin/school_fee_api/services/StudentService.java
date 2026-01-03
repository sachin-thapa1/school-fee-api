package com.sachin.school_fee_api.services;

import org.springframework.stereotype.Service;

import com.sachin.school_fee_api.entity.Student;
import com.sachin.school_fee_api.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository repo;
    public StudentService(StudentRepository repo){
        this.repo = repo;
    }
    public Student saveStudent(Student s) {
        System.out.println(">>>before save id = " + s.getId());
        Student saved = repo.save(s);
        System.out.println(">>> after save id = " + saved.getId());
        return saved;
    }

}
