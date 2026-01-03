package com.sachin.school_fee_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.school_fee_api.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
