package com.example.demo.repository;

import com.example.demo.entity.TopicLevel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicLevelRepository extends JpaRepository<TopicLevel,Integer> {
}
