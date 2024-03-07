package com.example.U8M1.school;

import com.example.U8M1.club.Club;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table
public class School {
    @Id
    @SequenceGenerator(
            name = "school_sequence",
            sequenceName = "school_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "school_sequence"
    )

    private Long id;

    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private Set<Club> club = new HashSet<>();

    private String name;
    private String missionStatement;
    private String phoneNum;
    private String clubs;

    public School(){
    }

    public School(Long id,
                  String name,
                  String missionStatement,
                  String phoneNum) {
        this.id = id;
        this.name = name;
        this.missionStatement = missionStatement;
        this.phoneNum = phoneNum;
    }

    public School(String name,
                  String missionStatement,
                  String phoneNum) {
        this.name = name;
        this.missionStatement = missionStatement;
        this.phoneNum = phoneNum;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getMissionStatement() {
        return missionStatement;
    }
    public void setMissionStatement(String missionStatement) {
        this.missionStatement = missionStatement;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public Set<Club> getClub() {
        return club;
    }

    @Override
    public String toString() {
        return "School{" +
                "id=" + id +
                ", name ='" + name + '\'' +
                ", missionStatement ='" + missionStatement + '\'' +
                ", phoneNum =" + phoneNum +
                '}';
    }
}
