package com.example.demo.repository;

import com.example.demo.model.TopicQustion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicQuestionRepository extends CrudRepository<TopicQustion,Long> {
}
