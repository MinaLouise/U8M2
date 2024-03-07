package com.example.U8M1.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SchoolRepository extends JpaRepository<School, Long> {
    @Query("SELECT s FROM School s WHERE s.name = ?1")
    Optional<School> findSchoolBy(String name);
}
