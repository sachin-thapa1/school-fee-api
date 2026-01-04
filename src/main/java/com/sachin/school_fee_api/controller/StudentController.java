package com.sachin.school_fee_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping
    public List<Student> all(){
        return service.getAllStudents();
  }

    @GetMapping("/{id}")
     public Student one(@PathVariable Long id) {
        return service.getStudentById(id);
  }

   @PutMapping("/{id}")
   public Student replace(@PathVariable Long id, @RequestBody Student s){
    return service.updateStudent(id, s);
   }

   @DeleteMapping ("/{id}")
   @ResponseStatus (HttpStatus.NO_CONTENT)
   public void delete(@PathVariable Long id){
    service.deleteStudent(id);
   }

}
