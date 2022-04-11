package com.example.demo.service;

import com.example.demo.entity.Application;
import com.example.demo.repository.ApplicationRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ApplicationService {
    private ApplicationRepository applicationRepository;

    public Page<Application> getAll (Integer page , Integer size){
        return applicationRepository.findAll(PageRequest.of(page,size));
    }

    public Application getReferenceById(Integer id){
        return applicationRepository.getById(id);
    }

    public Application save(Application application){
        return applicationRepository.save(application);
    }

    public void update(Application application){
        applicationRepository.save(application);
    }

    public void delete(Application application){
        applicationRepository.delete(application);
    }

    public Optional<Application>getById(Integer id) {
        return applicationRepository.findById(id);
    }


}
