package com.wanted.mission.domain;

import com.wanted.mission.dto.RecruitmentUpdateDto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@AllArgsConstructor
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
    @JoinColumn(name = "company_id", nullable = false) // foreign key (company_id) references company (company_id)
    private Company company;

    public void update(RecruitmentUpdateDto dto){
        this.content = dto.getContent();
        this.country = dto.getCountry();
        this.stack = dto.getStack();
        this.noticeDate = dto.getNoticeDate();
        this.position = dto.getPosition();
        this.region = dto.getRegion();
    }




}