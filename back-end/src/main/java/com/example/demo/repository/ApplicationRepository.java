package com.example.demo.repository;

import com.example.demo.entity.Application;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    @Query( value = "SELECT a FROM Application a INNER JOIN FETCH a.vacancy v WHERE v.id = :id",
    countQuery ="SELECT count(a) FROM Application a WHERE a.vacancy.id = :id")
    Page<Application> getApplicationByVacancyId(@Param("id")Integer id, Pageable pageable);
}
