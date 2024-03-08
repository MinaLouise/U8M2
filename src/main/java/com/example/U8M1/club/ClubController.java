package com.example.U8M1.club;

import com.example.U8M1.member.Member;
import com.example.U8M1.member.MemberService;
import com.example.U8M1.school.School;
import com.example.U8M1.school.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/club")
public class ClubController {
    private  ClubService clubService;
    private MemberService memberService;
    private SchoolService schoolService;

    @Autowired
    public ClubController(ClubService clubService, SchoolService schoolService, MemberService memberService){
        this.clubService = clubService;
        this.schoolService = schoolService;
        this.memberService = memberService;
    }

    @GetMapping
    public List<Club> getClubAll(){
        return clubService.getClubAll();
    }
    @GetMapping(path = "{clubId}")
    public Club getClubById(@PathVariable("clubId") Long clubId){
        return clubService.getClub(clubId);
    }
    @PostMapping
    public void registerNewClub(@RequestBody Club club){
        clubService.addNewClub(club);
    }

    @DeleteMapping(path = "{clubId}")
    public void deleteClub(@PathVariable("clubId") Long clubId){
        clubService.deleteClub(clubId);
    }

    @PutMapping(path = "{clubId}")
    public void updateClub(
            @PathVariable("clubId") Long clubId,
            @RequestParam(required = false)String name,
            @RequestParam(required = false)String leader,
            @RequestParam(required = false)String member){
        clubService.updateClub(clubId, name, leader, member);
    }

    @PutMapping("/{clubId}/members/{memberId}")
    Club addMemberToClub(
            @PathVariable Long clubId,
            @PathVariable Long memberId
    ) {
        Club club = clubService.getClub(clubId);
        Member member = memberService.getMember(memberId);
        club.clubMembers(member);
        return clubService.getClub(clubId);
    }

    @PutMapping("/{clubId}/school/{schoolId}")
    Club addSubjectTo(
            @PathVariable Long clubId,
            @PathVariable Long schoolId
    ) {
        Club club = clubService.getClub(clubId);
        School school = schoolService.getSchool(schoolId);
        club.schoolClubs(school);
        return clubService.getClub(clubId);
    }
}