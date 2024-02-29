package com.example.U8M1.member;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    public List<Member> getMembers(){
        return memberRepository.findAll();
    }
    public void addNewMember(Member member){
        Optional<Member> memberByEmail = memberRepository.findMemberByEmail(member.getEmail());
        if (memberByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        System.out.println(member);
        memberRepository.save(member);
    }
    public void deleteMember(Long memberId){
        boolean exists = memberRepository.existsById(memberId);
        if(!exists){
            throw new IllegalStateException(
                    "Member with id "+memberId+" does NOT exist."
            );
        }
        memberRepository.deleteById(memberId);
    }

    @Transactional
    public void updateMember(Long memberId,
                             String name,
                             String position,
                             String email) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                ()-> new IllegalStateException(
                        "Member with Id "+memberId+" does NOT exist."
                ));
        if (name != null &&
                !Objects.equals(member.getName(), name)){
            member.setName(name);
        }
        if (position != null &&
                !Objects.equals(member.getName(), position)){
            member.setPosition(position);
        }
        if (email != null &&
                email.length() >0 &&
                !Objects.equals(member.getEmail(), email)){
            Optional<Member> memberOptional = memberRepository.findMemberByEmail(email);
            if (memberOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            member.setEmail(email);
        }
    }

    public Member getMember(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                ()-> new IllegalStateException(
                        "Member with Id "+memberId+" does NOT exist."
                )
        );
    }
}
