package com.example.demo.service;

import com.example.demo.entity.Answer;
import com.example.demo.entity.Company;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AnswerService {

 private AnswerRepository answerRepository;

    public Page<Answer> getAll(Integer page, Integer size) {
        return answerRepository.findAll(PageRequest.of(page, size));
    }

    public Answer getReferenceById(Integer id) {
        return answerRepository.getById(id);
    }

    public Answer save(Answer answer) {
        return answerRepository.save(answer);
    }

    public void update(Answer answer) {
        answerRepository.save(answer);
    }

    public void delete(Answer answer) {
        answerRepository.delete(answer);
    }

    public Optional<Answer> getById(Integer id) {
        return answerRepository.findById(id);
    }
}
