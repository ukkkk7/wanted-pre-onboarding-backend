package com.wanted.mission.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Recruitment {


    @Id
    @Column(name = "recruitment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String region;
    private String country;
    private String position;
    private String content;
    private String stack;

    @Column(name = "notice_date")
    private String noticeDate;


    @OneToMany(mappedBy = "recruitment")
    private List<ApplyInformation> applyInformations = new ArrayList<>();


    @ManyToOne // Many = recruitment  one = company
    @JoinColumn(name = "company_id") // foreign key (company_id) references member (company_id)
    private Member member;


}
