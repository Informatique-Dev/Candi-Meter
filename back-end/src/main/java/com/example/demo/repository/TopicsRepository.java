package com.example.demo.repository;

import com.example.demo.entity.Topics;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TopicsRepository extends JpaRepository<Topics,Integer> {

}
