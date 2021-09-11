package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categorie_produit database table.
 */
@Entity
@Table(name = "categorie_produit")
@NamedQuery(name = "CategorieProduit.findAll", query = "SELECT c FROM CategorieProduit c")
public class CategorieProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie", unique = true, nullable = false)
    private Integer idCategorie;

    @Column(name = "libelle_categorie", length = 25)
    private String libelleCategorie;

    //bi-directional many-to-one association to Produit
    @JsonManagedReference
    @OneToMany(mappedBy = "categorieProduit",fetch = FetchType.EAGER)
    private List<Produit> produits;

    public CategorieProduit() {
    }

    public Integer getIdCategorie() {
        return this.idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibelleCategorie() {
        return this.libelleCategorie;
    }

    public void setLibelleCategorie(String libelleCategorie) {
        this.libelleCategorie = libelleCategorie;
    }

    public List<Produit> getProduits() {
        return this.produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }

    public Produit addProduit(Produit produit) {
        getProduits().add(produit);
        produit.setCategorieProduit(this);

        return produit;
    }

    public Produit removeProduit(Produit produit) {
        getProduits().remove(produit);
        produit.setCategorieProduit(null);

        return produit;
    }

}