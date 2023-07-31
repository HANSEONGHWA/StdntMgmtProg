package com.example.stdntmgmtprog.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //항목
    private String itemized;

    //납부유무
    private String paymentAvailability;

    //입금금액
    private String amount;

    @ManyToOne
    private Student s_id;

}
