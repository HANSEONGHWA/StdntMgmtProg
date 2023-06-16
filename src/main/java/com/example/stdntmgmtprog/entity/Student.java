package com.example.stdntmgmtprog.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer s_grade;

    private Integer s_ban;

    private Integer s_number;

    private String yearAdmission;

    @ManyToMany
    private Teacher homeroomTeacher;

    private String idPhoto;






}
