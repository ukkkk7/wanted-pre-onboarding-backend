package com.wanted.mission.dto;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RecruitmentSaveDto {

    private String region;
    private String country;
    private String content;
    private String stack;
    private String position;
    private String noticeDate;
    private Long companyId;

}
