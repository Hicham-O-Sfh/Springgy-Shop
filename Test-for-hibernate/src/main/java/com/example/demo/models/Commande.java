package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the commande database table.
 */
@Entity
@Table(name = "commande")
@NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_commande", unique = true, nullable = false)
    private Integer idCommande;

    @Temporal(TemporalType.DATE)
    @Column(name = "date_commande")
    private Date dateCommande;

    @Column(name = "paiement_effectue")
    private Boolean paiementEffectue;

    //bi-directional many-to-one association to Individuu
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_")
    private Individuu individu;

    public Commande() {
    }

    public Integer getIdCommande() {
        return this.idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDateCommande() {
        return this.dateCommande;
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Boolean getPaiementEffectue() {
        return this.paiementEffectue;
    }

    public void setPaiementEffectue(Boolean paiementEffectue) {
        this.paiementEffectue = paiementEffectue;
    }

    public Individuu getIndividu() {
        return this.individu;
    }

    public void setIndividu(Individuu individu) {
        this.individu = individu;
    }

}