package com.example.demo.service;

import com.example.demo.models.Produit;
import com.example.demo.repository.CategorieRepository;
import com.example.demo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProduitService {
    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    CategorieRepository categorieRepository;

    public List<Produit> listAll() {
        return produitRepository.findAll();
    }

    public void deleteProduit(Integer id) {
        produitRepository.deleteById(id);
    }

    public Produit getProduit(Integer id) {
        return produitRepository.findById(id).get();
    }

    public void saveInDatabase(Produit p) {
        produitRepository.save(p);
    }

    public Page<Produit> findAll(Pageable pageable) {
        return produitRepository.findAll(pageable);
    }

    public void remplirProduits() {
        produitRepository.save(new Produit(1234567890, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integer bibendum sodales arcu id te mpus. Ut consectetur lacus leo, non scelerisque nulla euismod nec.", "Chemise", 120.52d, categorieRepository.findById(1).get()));
        produitRepository.save(new Produit(123456789, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integer bibendum sodales arcu id te mpus. Ut consectetur lacus leo, non scelerisque nulla euismod nec.", "Chapeau", 80.40d, categorieRepository.findById(2).get()));
        produitRepository.save(new Produit(12345678, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integer bibendum sodales arcu id te mpus. Ut consectetur lacus leo, non scelerisque nulla euismod nec.", "Bottes cuires", 180.50d, categorieRepository.findById(1).get()));
        produitRepository.save(new Produit(1234567, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integer bibendum sodales arcu id te mpus. Ut consectetur lacus leo, non scelerisque nulla euismod nec.", "Tricot", 140, categorieRepository.findById(2).get()));
        produitRepository.save(new Produit(123456, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integer bibendum sodales arcu id te mpus. Ut consectetur lacus leo, non scelerisque nulla euismod nec.", "Chall", 50.58d, categorieRepository.findById(2).get()));
        produitRepository.save(new Produit(12345, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integer bibendum sodales arcu id te mpus. Ut consectetur lacus leo, non scelerisque nulla euismod nec.", "Veste", 400.72d, categorieRepository.findById(2).get()));
        produitRepository.save(new Produit(1234, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integer bibendum sodales arcu id te mpus. Ut consectetur lacus leo, non scelerisque nulla euismod nec.", "Pantalon", 130d, categorieRepository.findById(1).get()));
        produitRepository.save(new Produit(123, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integer bibendum sodales arcu id te mpus. Ut consectetur lacus leo, non scelerisque nulla euismod nec.", "Chaussettes", 17, categorieRepository.findById(1).get()));
        produitRepository.save(new Produit(12, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integer bibendum sodales arcu id te mpus. Ut consectetur lacus leo, non scelerisque nulla euismod nec.", "Boxer", 12.52d, categorieRepository.findById(2).get()));
        produitRepository.save(new Produit(1, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin pharetra tempor so dales. Phasellus sagittis auctor gravida. Integer bibendum sodales arcu id te mpus. Ut consectetur lacus leo, non scelerisque nulla euismod nec.", "Gant", 10.52d, categorieRepository.findById(7).get()));
    }
}
