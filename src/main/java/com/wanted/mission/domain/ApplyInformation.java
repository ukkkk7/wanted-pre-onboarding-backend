package com.wanted.mission.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;

@Table(name = "apply_information")
@Getter
@Setter
@Entity
public class ApplyInformation {

    @Id
    @Column(name = "apply_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY) // Many = applyInformation  one = member
    @JoinColumn(name = "member_id") // foreign key (member_id) references member (member_id)
    private Member member;


    @ManyToOne(fetch = FetchType.LAZY) //Many = applyInformation  one = recruitment
    @JoinColumn(name = "recruitment_id") // foreign key (recruitment_id) references member (recruitment_id)
    private Recruitment recruitment;


}
