package com.example.demo.repository;

import com.example.demo.model.Topics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicsRepository extends CrudRepository<Topics,Long> {
}
