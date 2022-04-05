package com.example.demo.repository;

import com.example.demo.model.Position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends JpaRepository<Position,Long> {
}
