package com.example.U8M1.club;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {
    @Query("SELECT s FROM Club s WHERE s.leader = ?1")
    Optional<Club> findClubByLeader(String leader);
}
