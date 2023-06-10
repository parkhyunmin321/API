package com.codingrecipe.member.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {
    @Id

    @Column(unique = true)
    private String steam_id;

    @Column
    private String steam_api_key;
}
