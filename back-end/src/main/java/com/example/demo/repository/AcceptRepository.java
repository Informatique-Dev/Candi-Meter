package com.example.demo.repository;

import com.example.demo.entity.Accept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcceptRepository extends JpaRepository<Accept, Integer> {
}
