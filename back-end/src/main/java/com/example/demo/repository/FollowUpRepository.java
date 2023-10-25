package com.example.demo.repository;


import com.example.demo.entity.FollowUp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FollowUpRepository extends JpaRepository<FollowUp, Integer> {




    @Query(value = "SELECT f FROM FollowUp f JOIN FETCH f.interview  WHERE f.id = :id")
    Optional<FollowUp> findById(@Param("id") Integer id);

    @Query(value = " SELECT f FROM FollowUp f JOIN FETCH f.interview  WHERE f.interview.id= :interviewId",
            countQuery = "SELECT COUNT(f) FROM FollowUp f WHERE f.interview.id= :interviewId")
    Page<FollowUp> findAllByInterview(@Param(value = "interviewId") Integer interviewId, Pageable pageable);

}
