package com.example.demo.service;

import com.example.demo.models.Sexe;
import com.example.demo.repository.SexeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SexeServiceImp implements SexeService {

    @Autowired
    SexeRepository sexeRepository;

    @Override
    public Iterable<Sexe> findAll() {
        return sexeRepository.findAll();
    }
}
