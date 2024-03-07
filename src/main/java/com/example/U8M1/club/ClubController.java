package com.example.U8M1.club;

import com.example.U8M1.member.Member;
import com.example.U8M1.member.MemberRepository;
import com.example.U8M1.school.School;
import com.example.U8M1.school.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/club")
public class ClubController {
    private  ClubService clubService;
    private ClubRepository clubRepository;
    private MemberRepository memberRepository;
    private SchoolRepository schoolRepository;

    @Autowired
    public ClubController(ClubService clubService){
        this.clubService = clubService;
    }
    public ClubController(ClubRepository clubRepository){
        this.clubRepository = clubRepository;
    }
    public ClubController(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }
    public ClubController(SchoolRepository schoolRepository){
        this.schoolRepository = schoolRepository;
    }

    @GetMapping
    public List<Club> getClub(){
        return clubService.getClub();
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
        Club club = clubRepository.findById(clubId).get();
        Member member = memberRepository.findById(memberId).get();
        club.clubMembers(member);
        return clubRepository.save(club);
    }

    @PutMapping("/{clubId}/school/{schoolId}")
    Club addSubjectTo(
            @PathVariable Long clubId,
            @PathVariable Long schoolId
    ) {
        Club club = clubRepository.findById(clubId).get();
        School school = schoolRepository.findById(schoolId).get();
        club.schoolClubs(school);
        return clubRepository.save(club);
    }
}