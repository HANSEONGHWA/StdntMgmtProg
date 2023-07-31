package com.example.stdntmgmtprog.entity;


import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class Achievement {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String semester;

        private Integer kor;

        private Integer eng;

        private Integer math;

        private Integer sum;

        private Integer avg;

        private Integer rating;
}
