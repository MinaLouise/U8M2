package com.example.U8M1.club;

import com.example.U8M1.member.Member;
import com.example.U8M1.school.School;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table
public class Club {

    @Id
    @SequenceGenerator(
            name = "club_sequence",
            sequenceName = "club_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "club_sequence"
    )
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "member_enrolled",
            joinColumns = @JoinColumn(name = "club_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private Set<Member> clubMembers = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id"
    )
    private School school;

    private String name;
    private String leader;

    public Club(){
    }

    public Club(Long id,
                String name,
                String leader,
                String member) {
        this.id = id;
        this.name = name;
        this.leader = leader;
    }

    public Club(String name,
                String leader,
                String member) {
        this.name = name;
        this.leader = leader;
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

    public String getLeader() {
        return leader;
    }
    public void setLeader(String leader) {
        this.leader = leader;
    }

    public Set<Member> getClubMembers() {
        return clubMembers;
    }
    public void clubMembers(Member member) {
        clubMembers.add(member);
    }

    public School getSchool() {
        return school;
    }

    @Override
    public String toString() {
        return "Club{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", leader='" + leader + '\'' +
                '}';
    }

    public void schoolClubs(School school) {
        this.school = school;
    }
}
