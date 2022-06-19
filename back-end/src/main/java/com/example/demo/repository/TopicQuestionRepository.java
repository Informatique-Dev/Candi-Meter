package com.example.demo.repository;

import com.example.demo.entity.TopicQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TopicQuestionRepository extends JpaRepository<TopicQuestion,Integer> {
}
