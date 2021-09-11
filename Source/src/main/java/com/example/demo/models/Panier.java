package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the panier database table.
 */
@Entity
@Table(name = "panier")
@NamedQuery(name = "Panier.findAll", query = "SELECT p FROM Panier p")
public class Panier {
//	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ajout_panier", unique = true, nullable = false)
    private Integer idAjoutPanier;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_ajout_panier")
    private Date dateAjoutPanier;

    //bi-directional many-to-one association to Individuu
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_")
    private Individuu individu;

    //bi-directional many-to-one association to Produit
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_")
    private Produit produitBean;

    public Panier() {
    }

    public Integer getIdAjoutPanier() {
        return this.idAjoutPanier;
    }

    public void setIdAjoutPanier(Integer idAjoutPanier) {
        this.idAjoutPanier = idAjoutPanier;
    }

    public Date getDateAjoutPanier() {
        return this.dateAjoutPanier;
    }

    public void setDateAjoutPanier(Date dateAjoutPanier) {
        this.dateAjoutPanier = dateAjoutPanier;
    }

    public Individuu getIndividu() {
        return this.individu;
    }

    public void setIndividu(Individuu individu) {
        this.individu = individu;
    }

    public Produit getProduitBean() {
        return this.produitBean;
    }

    public void setProduitBean(Produit produitBean) {
        this.produitBean = produitBean;
    }

}