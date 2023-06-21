package com.example.stdntmgmtprog.service;

import com.example.stdntmgmtprog.entity.Student;
import com.example.stdntmgmtprog.entity.dto.StudentDto;
import com.example.stdntmgmtprog.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void create(StudentDto dto) {
        Student std = Student.builder()
                .birth(dto.getBirth())
                .name(dto.getName())
                .s_grade(dto.getS_grade())
                .s_ban(dto.getS_ban())
                .s_number(dto.getS_number())
                .yearAdmission(dto.getYearAdmission())
                .build();
        studentRepository.save(std);

    }
}
