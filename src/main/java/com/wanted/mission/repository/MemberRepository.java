package com.wanted.mission.repository;

import com.wanted.mission.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, String > {

}

