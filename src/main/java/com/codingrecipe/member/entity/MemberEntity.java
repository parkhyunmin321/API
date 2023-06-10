package com.codingrecipe.member.entity;

import com.codingrecipe.member.dto.MemberDTO;
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

//    public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
//        MemberEntity memberEntity = new MemberEntity();
//        memberEntity.setSteam_id(memberDTO.getSteam_id());
//        memberEntity.setSteam_api_key(memberDTO.getSteam_api_key());
//    }
}
