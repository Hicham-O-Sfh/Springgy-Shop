package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/*
TODO
-ajouter contrainte de validation pour chaque attribut
-ajouter la validation javascript(seulement) sur les champs de la VIEW
 */
@Entity
@Table(name = "produit")
@NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p")
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produit", unique = true, nullable = false)
    private Integer idProduit;

    @Column(name = "code_barre")
    private Integer codeBarre;

    @Column(name = "description_produit", length = 1500)
    private String descriptionProduit;

    @Column(name = "libelle_produit", length = 150)
    private String libelleProduit;

    @Column(name = "chemin_image", length = 300)
    private String cheminImage;

    private double prix;

    //bi-directional many-to-one association to Panier
    @JsonIgnore
    @OneToMany(mappedBy = "produitBean", fetch = FetchType.LAZY)
    private List<Panier> paniers;

    //bi-directional many-to-one association to CategorieProduit
    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categorie_")
    private CategorieProduit categorieProduit;

    public Produit() {
    }


    public Produit(Integer codeBarre, String descriptionProduit, String libelleProduit, double prix, CategorieProduit categorieProduit) {
        this.codeBarre = codeBarre;
        this.descriptionProduit = descriptionProduit;
        this.libelleProduit = libelleProduit;
        this.prix = prix;
        this.categorieProduit = categorieProduit;
    }

    public String getCheminImage() {
        return cheminImage;
    }

    public void setCheminImage(String cheminImage) {
        this.cheminImage = cheminImage;
    }

    public Integer getIdProduit() {
        return this.idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getCodeBarre() {
        return this.codeBarre;
    }

    public void setCodeBarre(Integer codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getDescriptionProduit() {
        return this.descriptionProduit;
    }

    public void setDescriptionProduit(String descriptionProduit) {
        this.descriptionProduit = descriptionProduit;
    }

    public String getLibelleProduit() {
        return this.libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public double getPrix() {
        return this.prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public List<Panier> getPaniers() {
        return this.paniers;
    }

    public void setPaniers(List<Panier> paniers) {
        this.paniers = paniers;
    }

    public Panier addPanier(Panier panier) {
        getPaniers().add(panier);
        panier.setProduitBean(this);

        return panier;
    }

    public Panier removePanier(Panier panier) {
        getPaniers().remove(panier);
        panier.setProduitBean(null);

        return panier;
    }

    public CategorieProduit getCategorieProduit() {
        return this.categorieProduit;
    }


    public void setCategorieProduit(CategorieProduit categorieProduit) {
        this.categorieProduit = categorieProduit;
    }

}