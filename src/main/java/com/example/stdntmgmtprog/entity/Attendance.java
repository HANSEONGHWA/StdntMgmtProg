package com.example.stdntmgmtprog.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public class Attendance {

    @ManyToOne
    private Student s_id;

    private Integer Date;

    //출결사항
    private String attendance;

    //출석일수
    private Integer classDays;

    //결석일수
    private Integer numberAbsences;

}
