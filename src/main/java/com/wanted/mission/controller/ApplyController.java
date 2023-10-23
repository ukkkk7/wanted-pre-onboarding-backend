package com.wanted.mission.controller;

import com.wanted.mission.domain.ApplyInformation;
import com.wanted.mission.dto.ApplyDto;
import com.wanted.mission.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recruitment")
public class ApplyController {


    private final MemberService memberService;


    @PostMapping("/apply")
    public String apply(@RequestBody ApplyInformation applyInformation){


        memberService.apply(applyInformation);

        return "지원이 완료되었습니다.";

    }


}
