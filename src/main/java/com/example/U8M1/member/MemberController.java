package com.example.U8M1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path="api/v1/member")
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    @GetMapping
    public List<Member> getMemberAll(){
        return memberService.getMemberAll();
    }
    @GetMapping(path = "{memberId}")
    public Member getMemberById(@PathVariable("memberId") Long memberId){
        return memberService.getMember(memberId);
    }
    @PostMapping
    public void registerNewMember(@RequestBody Member member){
        memberService.addNewMember(member);
    }

    @DeleteMapping(path = "{memberId}")
    public void deleteMember(@PathVariable("memberId") Long memberId){
        memberService.deleteMember(memberId);
    }

    @PutMapping(path = "{memberId}")
    public void updateMember(
            @PathVariable("memberId") Long memberId,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String position,
            @RequestParam(required = false)String email){
        memberService.updateMember(memberId, name, position, email);
    }
}