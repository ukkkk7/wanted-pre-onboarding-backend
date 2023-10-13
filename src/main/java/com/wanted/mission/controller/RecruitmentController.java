package com.wanted.mission.controller;


import com.wanted.mission.domain.Recruitment;
import com.wanted.mission.dto.RecruitmentDto;
import com.wanted.mission.dto.RecruitmentSaveDto;
import com.wanted.mission.dto.RecruitmentUpdateDto;
import com.wanted.mission.service.RecruitmentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@RestController
@RequestMapping("/recruitment")
public class RecruitmentController {


    private final RecruitmentService recruitmentService;
    private final ModelMapper modelMapper;


    @PostMapping("/add")
        public RecruitmentSaveDto createRecruitment(@RequestBody Recruitment recruitment) {

                recruitmentService.save(recruitment);
                // 저장한 데이터 entity -> dto로 바인딩 후 반환
                return modelMapper.map(recruitment, RecruitmentSaveDto.class);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteRecruitment(@PathVariable("id") Long id){

        recruitmentService.delete(id);

        return "공고가 삭제되었습니다.";

    }



    @GetMapping("/list")
    public List<RecruitmentDto> getRecruitmentList(){

        //조회
        List<Recruitment> recruitment = recruitmentService.findAll();

        //조회한 list dto로 바인딩 후 반환
        List<RecruitmentDto> getList = recruitment.stream()
                .map(data -> modelMapper.map(data, RecruitmentDto.class))
                .collect(Collectors.toList());

        return getList;

    }


    @PatchMapping("/update/{id}")
    public RecruitmentUpdateDto updateRecruitment(@PathVariable("id") Long id, RecruitmentUpdateDto recruitmentUpdateDto){

        Recruitment resultData = recruitmentService.updateRecruit(recruitmentUpdateDto, id);

        return modelMapper.map(resultData, RecruitmentUpdateDto.class);

    }
}