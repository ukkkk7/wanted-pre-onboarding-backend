package com.wanted.mission.service;

import com.wanted.mission.domain.ApplyInformation;
import com.wanted.mission.domain.Member;
import com.wanted.mission.domain.Recruitment;
import com.wanted.mission.dto.ApplyDto;
import com.wanted.mission.exception.DuplicateApplicationException;
import com.wanted.mission.repository.ApplyRepository;
import com.wanted.mission.repository.MemberRepository;
import com.wanted.mission.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final RecruitmentRepository recruitmentRepository;
    private final ApplyRepository applyRepository;

    public void apply(ApplyInformation applyInformation) {

//        Member member = memberRepository.findById(applyDto.getMemberId())
//                                        .orElseThrow(() -> new EntityNotFoundException("Member not found with id: " + applyDto.getMemberId()));
//
//        Recruitment recruitment = recruitmentRepository.findById(applyDto.getRecruitmentId())
//                                                       .orElseThrow(() -> new EntityNotFoundException("recruitment not found with id: " + applyDto.getRecruitmentId()));


        if(applyRepository.existsByMemberAndRecruitment(applyInformation.getMember(), applyInformation.getRecruitment())){
            throw new DuplicateApplicationException("이미 지원하신 공고입니다.");
        }

        applyRepository.save(applyInformation);

}
}