package com.example.stdntmgmtprog.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date date;

    //주관기관명
    private String institution;

    //활동내용
    private String Activities;

    //봉사시간
    private Integer hour;

    @ManyToOne
    private Student s_id;


}
