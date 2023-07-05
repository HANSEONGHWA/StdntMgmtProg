package com.example.stdntmgmtprog.entity.dto;

import com.example.stdntmgmtprog.entity.Student;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class StudentDto {

    private String name;

    private String birth;

    private String s_grade;

    private String s_ban;

    private Integer s_number;

    private String yearAdmission;

    private String fileName;

    private String fileOriName;

    private String fileUrl;


    public StudentDto(Student student) {
            this.name = student.getName();
            this.birth = student.getBirth();
            this.s_grade = student.getS_grade();
            this.s_ban = student.getS_ban();
            this.s_number = student.getS_number();
            this.yearAdmission = student.getYearAdmission();
            this.fileName = student.getFileName();
            this.fileOriName = student.getFileOriName();
        this.fileUrl = student.getFileUrl();
    }

    public Student dtoToEntity() {
        return Student.builder()
                .name(name)
                .birth(birth)
                .s_grade(s_grade)
                .s_ban(s_ban)
                .s_number(s_number)
                .yearAdmission(yearAdmission)
                .fileName(fileName)
                .fileOriName(fileOriName)
                .fileUrl(fileUrl)
                .build();
    }
}
