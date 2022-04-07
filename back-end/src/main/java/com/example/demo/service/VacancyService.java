package com.example.demo.service;

import com.example.demo.entity.Vacancy;
import com.example.demo.repository.VacancyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class VacancyService {

    private VacancyRepository vacancyRepository;

    public Page<Vacancy> getAll(Integer page, Integer size) {
        return vacancyRepository.findAll(PageRequest.of(page, size));
    }

    public Vacancy getReferenceById(Integer id) {
        return vacancyRepository.getById(id);
    }

    public Vacancy save(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    public void update(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    public void delete(Vacancy vacancy) {
        vacancyRepository.delete(vacancy);
    }

    public Optional<Vacancy> getById(Integer id) {
        return vacancyRepository.findById(id);
    }
}