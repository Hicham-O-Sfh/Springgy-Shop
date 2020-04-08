package com.example.demo.repository;

import com.example.demo.models.Sexe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexeRepository extends CrudRepository<Sexe, Integer> {

    @Override
    Iterable<Sexe> findAll();
}
