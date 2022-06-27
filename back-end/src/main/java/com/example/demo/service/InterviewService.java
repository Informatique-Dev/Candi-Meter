package com.example.demo.service;


import com.example.demo.entity.Interview;
import com.example.demo.repository.InterviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class InterviewService {
    private InterviewRepository interviewRepository;

    public Page<Interview> getAll(Integer page, Integer size) {
        return interviewRepository.findAll(PageRequest.of(page, size));
    }

    public Interview getReferenceById(Integer id) {
        return interviewRepository.getById(id);
    }

    public Interview save(Interview interview) {
        return interviewRepository.save(interview);
    }

    public void update(Interview interview) {
        interviewRepository.save(interview);
    }

    public void delete(Interview interview) {
        interviewRepository.delete(interview);
    }

    public Optional<Interview> getById(Integer id) {
        return interviewRepository.findById(id);
    }
}
