package com.wanted.mission.repository;

import com.wanted.mission.domain.Recruitment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RecruitmentRepository extends JpaRepository<Recruitment, Long> {

    @Query("select r.id from Recruitment r where r.company.id = :companyId")
    List<Long> getRelatedRecruitment(@Param("companyId") Long companyId);

    @Query("select r from Recruitment r where r.position like %:keyword% OR r.content like %:keyword% OR " +
            "r.region like %:keyword% OR r.stack like %:keyword%")
    List<Recruitment> searchRecruitment(@Param("keyword") String keyword);



}
