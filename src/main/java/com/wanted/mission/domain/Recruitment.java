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


    @OneToMany(mappedBy = "recruitment", cascade = CascadeType.REMOVE)
    private List<ApplyInformation> applyInformations = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST) // Many = recruitment  one = company
    @JoinColumn(name = "company_id", nullable = false) // foreign key (company_id) references company (company_id)
    private Company company;

    public void update(RecruitmentUpdateDto dto){
        if(dto.getContent()!=null) this.content = dto.getContent();
        if(dto.getCountry()!=null) this.country = dto.getCountry();
        if(dto.getStack()!=null) this.stack = dto.getStack();
        if(dto.getNoticeDate()!=null) this.noticeDate = dto.getNoticeDate();
        if(dto.getPosition()!=null) this.position = dto.getPosition();
        if(dto.getRegion()!=null) this.region = dto.getRegion();
    }




}