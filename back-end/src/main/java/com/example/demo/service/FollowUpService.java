package com.example.demo.service;

import com.example.demo.entity.Answer;
import com.example.demo.entity.FollowUp;
import com.example.demo.repository.AnswerRepository;
import com.example.demo.repository.FollowUpRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class FollowUpService {

    private FollowUpRepository followUpRepository;



    public Optional<FollowUp> getById(Integer id){
        return followUpRepository.findById(id);
    }

    public FollowUp save(FollowUp followUp) {
        return followUpRepository.save(followUp);
    }


    public Page<FollowUp> getAllByInterview(Integer interviewId, Integer page, Integer size) {
        return followUpRepository.findAllByInterview(interviewId, PageRequest.of(page, size));
    }

    public void delete(FollowUp followUp) {

        followUpRepository.delete(followUp);
    }
}
