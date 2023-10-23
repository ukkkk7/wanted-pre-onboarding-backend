package com.wanted.mission.repository;

import com.wanted.mission.domain.ApplyInformation;
import com.wanted.mission.domain.Member;
import com.wanted.mission.domain.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplyRepository extends JpaRepository<ApplyInformation, Long> {
    boolean existsByMemberAndRecruitment(Member member, Recruitment recruitment);
}
