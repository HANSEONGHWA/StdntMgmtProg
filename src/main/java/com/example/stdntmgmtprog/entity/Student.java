package com.example.stdntmgmtprog.entity;

import jakarta.persistence.*;
import lombok.*;

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

    private String idPhoto;

}
