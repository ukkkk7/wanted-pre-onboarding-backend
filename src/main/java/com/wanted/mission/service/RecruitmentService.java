package com.wanted.mission.service;

import com.wanted.mission.domain.Recruitment;
import com.wanted.mission.repository.RecruitmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RecruitmentService {

    private final RecruitmentRepository recruitmentRepository;

    public void save(Recruitment recruitment) {
        recruitmentRepository.save(recruitment);
    }


}
