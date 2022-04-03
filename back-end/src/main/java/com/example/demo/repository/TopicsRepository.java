package com.example.demo.repository;

import com.example.demo.model.Topics;
import org.springframework.data.repository.CrudRepository;

public interface TopicsRepository extends CrudRepository<Topics,Long> {
}
