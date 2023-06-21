package com.example.stdntmgmtprog.repository;

import com.example.stdntmgmtprog.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
