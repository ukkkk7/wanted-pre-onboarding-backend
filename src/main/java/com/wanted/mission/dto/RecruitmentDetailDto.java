package com.wanted.mission.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecruitmentDetailDto {


    private String region;
    private String country;
    private String content;
    private String stack;
    private String position;
    private String noticeDate;
    private Long companyId;
    private List<Long> relatedRecruitment;




}
