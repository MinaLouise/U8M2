package com.example.U8M1.member;

import com.example.U8M1.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT s FROM Member s WHERE s.email = ?1")
    Optional<Member> findMemberByEmail(String email);
}
