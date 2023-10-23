package com.wanted.mission.domain;


import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Member {



    @Column(name = "member_id", nullable = false)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String account;

    @Column
    private String password;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<ApplyInformation> applyInformations = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Authority> roles = new ArrayList<>();


    public void setRoles(List<Authority> role) {
        this.roles = role;
        role.forEach(o -> o.setMember(this));
    }


}
