package com.example.stdntmgmtprog.entity;

import jakarta.persistence.*;
import lombok.Getter;



@Entity
@Getter
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String t_id;

    private String t_grade;

    private String t_ban;

    private String t_name;



}
