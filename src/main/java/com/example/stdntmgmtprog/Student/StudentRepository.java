package com.example.stdntmgmtprog.Student;

import com.example.stdntmgmtprog.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer>{

    List<Student> findByYearAdmission(String yearAdmission);


}
