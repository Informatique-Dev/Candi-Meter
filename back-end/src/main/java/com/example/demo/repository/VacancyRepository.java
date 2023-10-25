package com.example.demo.repository;

import com.example.demo.entity.Vacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Integer>{



    @Query(value = "SELECT v from Vacancy v  JOIN FETCH v.postBy  as A  WHERE A.username= :userName",
            countQuery = "SELECT count(v) FROM Vacancy v  WHERE v.postBy.username= :userName ")
    Page<Vacancy> getVacationsByUser(@Param("userName") String userName, Pageable pageable);
}
