package com.example.demo.repository;

import com.example.demo.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    @Query(value = "SELECT c FROM Candidate c WHERE c.phone= :phone")
    Optional<Candidate> findByPhone(@Param("phone") String phone);

    @Query(value = "SELECT c FROM Candidate c WHERE c.phone= :phone")
    Candidate findCandidateByPhone(@Param("phone") String phone);
}
