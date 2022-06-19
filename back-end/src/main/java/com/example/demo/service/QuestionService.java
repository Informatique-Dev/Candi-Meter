package com.example.demo.service;

import com.example.demo.entity.Question;
import com.example.demo.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionService {
    private QuestionRepository questionRepository;

    public Page<Question> getAll(Integer page, Integer size) {
        return questionRepository.findAll(PageRequest.of(page, size));
    }

    public Question getReferenceById(Integer id) {
        return questionRepository.getById(id);
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public void update(Question question) {
        questionRepository.save(question);
    }

    public void delete(Question question) {
        questionRepository.delete(question);
    }

    public Optional<Question> getById(Integer id) {
        return questionRepository.findById(id);
    }
}
