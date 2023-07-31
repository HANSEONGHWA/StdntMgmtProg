package com.example.stdntmgmtprog.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String birth;

    private String s_grade;

    private String s_ban;

    private Integer s_number;

    private String yearAdmission;

//    @ManyToMany
//    private Teacher t_id;

    private String fileName;

    private String fileOriName;

    private String fileUrl;


}
