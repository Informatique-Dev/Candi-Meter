package com.example.demo.repository;

import com.example.demo.entity.Candidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    @Query( value = "SELECT c FROM Candidate c INNER JOIN FETCH c.position p WHERE p.id = :id",
            countQuery ="SELECT count(c) FROM Candidate c WHERE c.position.id = :id")
    Page<Candidate> getByPositionId(@Param("id")Integer id, Pageable pageable);
}
