package com.example.demo.repository;

import com.example.demo.models.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaysRepository extends JpaRepository<Pay, Integer> {

    @Override
    List<Pay> findAll();
}
