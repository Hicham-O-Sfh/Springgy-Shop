package com.example.demo.models;

public class ProduitViewModel {

    private Integer idProduit;
    private Integer codeBarre;
    private String descriptionProduit;
    private String libelleProduit;
    private double prix;
    private CategorieProduit categorieProduit;
    private Integer idCategorie;

    public ProduitViewModel() {
    }

    public ProduitViewModel(Integer codeBarre, String descriptionProduit, String libelleProduit, double prix, CategorieProduit categorieProduit) {
        this.codeBarre = codeBarre;
        this.descriptionProduit = descriptionProduit;
        this.libelleProduit = libelleProduit;
        this.prix = prix;
        this.categorieProduit = categorieProduit;
        this.idCategorie = categorieProduit.getIdCategorie();
    }

    public void Copie(Produit p) {
        this.idProduit = p.getIdProduit();
        this.codeBarre = p.getCodeBarre();
        this.descriptionProduit = p.getDescriptionProduit();
        this.libelleProduit = p.getLibelleProduit();
        this.prix = p.getPrix();
        this.categorieProduit = p.getCategorieProduit();
        this.idCategorie = p.getCategorieProduit().getIdCategorie();
    }

    public Integer getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Integer idProduit) {
        this.idProduit = idProduit;
    }

    public Integer getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(Integer codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getDescriptionProduit() {
        return descriptionProduit;
    }

    public void setDescriptionProduit(String descriptionProduit) {
        this.descriptionProduit = descriptionProduit;
    }

    public String getLibelleProduit() {
        return libelleProduit;
    }

    public void setLibelleProduit(String libelleProduit) {
        this.libelleProduit = libelleProduit;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public CategorieProduit getCategorieProduit() {
        return categorieProduit;
    }

    public void setCategorieProduit(CategorieProduit categorieProduit) {
        this.categorieProduit = categorieProduit;
    }

    public Integer getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Integer idCategorie) {
        this.idCategorie = idCategorie;
    }
}
