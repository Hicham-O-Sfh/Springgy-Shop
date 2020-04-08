package com.example.demo.service;

import com.example.demo.models.Pay;
import com.example.demo.repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PaysServiceImp implements PaysService {

    @Autowired
    PaysRepository paysRepository;

    @Override
    public List<Pay> findAll() {
        return paysRepository.findAll();
    }
}
