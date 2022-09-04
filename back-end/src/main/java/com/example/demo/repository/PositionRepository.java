package com.example.demo.repository;

import com.example.demo.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface PositionRepository extends JpaRepository<Position,Integer> {
    @Query(value = "SELECT p FROM Position p WHERE p.name = :name")
    Optional<Position> findByName(@Param("name") String name);
}
