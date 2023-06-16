package com.example.stdntmgmtprog.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
