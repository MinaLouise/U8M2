package com.example.U8M1.club;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClubService {
    private final ClubRepository clubRepository;

    @Autowired
    public ClubService(ClubRepository clubRepository){
        this.clubRepository = clubRepository;
    }
    public List<Club> getClubAll(){
        return clubRepository.findAll();
    }
    public void addNewClub(Club club){
        Optional<Club> clubByLeader = clubRepository.findClubByLeader(club.getLeader());
        if (clubByLeader.isPresent()){
            throw new IllegalStateException("leader not found");
        }
        System.out.println(club);
        clubRepository.save(club);
    }
    public void deleteClub(Long clubId){
        boolean exists = clubRepository.existsById(clubId);
        if(!exists){
            throw new IllegalStateException(
                    "Club with id "+clubId+" does NOT exist."
            );
        }
        clubRepository.deleteById(clubId);
    }

    @Transactional
    public void updateClub(Long clubId,
                             String name,
                             String member,
                             String leader) {
        Club club = clubRepository.findById(clubId).orElseThrow(
                ()-> new IllegalStateException(
                        "Member with Id "+clubId+" does NOT exist."
                ));
        if (name != null &&
                !Objects.equals(club.getName(), name)){
            club.setName(name);
        }
        if (member != null &&
                !Objects.equals(club.getName(), member)){
            club.setLeader(member);
        }
        if (leader != null &&
                !leader.isEmpty() &&
                !Objects.equals(club.getLeader(), leader)){
            Optional<Club> clubOptional = clubRepository.findClubByLeader(leader);
            if (clubOptional.isPresent()){
                throw new IllegalStateException("no such leader");
            }
            club.setLeader(leader);
        }
    }

    public Club getClub(Long clubId) {
        return clubRepository.findById(clubId).orElseThrow(
                ()-> new IllegalStateException(
                        "Club with Id "+clubId+" does NOT exist."
                )
        );
    }
}
