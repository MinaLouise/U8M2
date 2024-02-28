package com.example.U8M1.member;

import jakarta.persistence.*;

@Entity
@Table
public class Member {
    @Id
    @SequenceGenerator(
            name = "member_sequence",
            sequenceName = "member_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_sequence"
    )

    private Long id;
    private String name;
    private String position;
    private String email;
    private String phoneNum;

    public Member(){
    }

    public Member(Long id,
                  String name,
                  String position,
                  String email,
                  String phoneNum) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNum = phoneNum;
    }

    public Member(String name,
                  String position,
                  String email,
                  String phoneNum) {
        this.name = name;
        this.position = position;
        this.email = email;
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

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phoneNum=" + phoneNum +
                '}';
    }
}
