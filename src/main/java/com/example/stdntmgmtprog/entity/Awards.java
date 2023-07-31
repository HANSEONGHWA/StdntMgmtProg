package com.example.stdntmgmtprog.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

public class Awards {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //학기
    private String semester;

    //학년
    private String grade;

    //학생정보
    @ManyToOne
    private Student s_id;

    //수상명
    private String award;

    //등급(위)
    private String awardGrade;

    //수상년월일
    private Date date;
}
