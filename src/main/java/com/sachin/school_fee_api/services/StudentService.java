package com.sachin.school_fee_api.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public List <Student>getAllStudents(){
        return repo.findAll();
    }
    public Student getStudentById(Long id){
        return repo.findById(id).
        orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
    public void deleteStudent(Long id){
        if(!repo.existsById(id)) throw new
        ResponseStatusException(HttpStatus.NOT_FOUND);
        repo.deleteById(id);
    }
    public Student updateStudent(Long id, Student incoming){
        return repo.findById(id).map(s -> {s.setName(incoming.getName()); return repo.save(s);
        }) . orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
