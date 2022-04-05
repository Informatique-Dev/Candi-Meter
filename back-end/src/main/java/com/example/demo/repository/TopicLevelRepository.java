package com.example.demo.repository;

import com.example.demo.model.TopicLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TopicLevelRepository extends JpaRepository<TopicLevel,Long> {
}
