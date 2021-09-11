package com.example.demo.service;

import com.example.demo.models.CategorieProduit;
import com.example.demo.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CategorieService {
    @Autowired
    CategorieRepository categorieRepository;

    public List<CategorieProduit> listAll(){
        return  categorieRepository.findAll();
    }
}
