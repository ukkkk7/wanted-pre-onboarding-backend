package com.wanted.mission.domain;

import lombok.Getter;

import javax.persistence.*;


@Getter
@Entity
public class Company {

    @Id
    @Column(name = "company_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


}
