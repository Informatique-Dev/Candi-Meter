package com.example.demo.repository;

import com.example.demo.model.TopicLevel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicLevelRepository extends CrudRepository<TopicLevel,Long> {
}
