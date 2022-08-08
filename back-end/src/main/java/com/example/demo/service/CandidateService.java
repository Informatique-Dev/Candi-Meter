package com.example.demo.service;

import com.example.demo.entity.Candidate;
import com.example.demo.repository.CandidateRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CandidateService {

    private CandidateRepository candidateRepository;

    public Page<Candidate> getAll(Integer page, Integer size) {
        return candidateRepository.findAll(PageRequest.of(page, size));
    }
    public Page<Candidate> getAllByPositionId (Integer page , Integer size , Integer id){
        return candidateRepository.getByPositionId(id,PageRequest.of(page,size));
    }
    public Candidate getReferenceById(Integer id) {
        return candidateRepository.getById(id);
    }

    public Candidate save(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public void update(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    public void delete(Candidate candidate) {
        candidateRepository.delete(candidate);
    }

    public Optional<Candidate> getById(Integer id) {
        return candidateRepository.findById(id);
    }

}
