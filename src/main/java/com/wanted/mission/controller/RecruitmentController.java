package com.wanted.mission.controller;


import com.wanted.mission.domain.Recruitment;
import com.wanted.mission.dto.RecruitmentSaveDto;
import com.wanted.mission.service.RecruitmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/recruitment")
public class RecruitmentController {


    private final RecruitmentService recruitmentService;
    private final ModelMapper modelMapper;


    @PostMapping("/add")
        public RecruitmentSaveDto create(@RequestBody Recruitment recruitment) {

                recruitmentService.save(recruitment);

                return modelMapper.map(recruitment, RecruitmentSaveDto.class);
    }






}