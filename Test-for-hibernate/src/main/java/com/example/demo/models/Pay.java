package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the pays database table.
 */
@Entity
@Table(name = "pays")
@NamedQuery(name = "Pay.findAll", query = "SELECT p FROM Pay p")
public class Pay {
//	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pays", unique = true, nullable = false)
    private Integer idPays;

    @Column(name = "libelle_pays", length = 25)
    private String libellePays;

    //bi-directional many-to-one association to Individuu
    @OneToMany(mappedBy = "pay")
    private List<Individuu> individus;

    public Pay() {
    }

    public Integer getIdPays() {
        return this.idPays;
    }

    public void setIdPays(Integer idPays) {
        this.idPays = idPays;
    }

    public String getLibellePays() {
        return this.libellePays;
    }

    public void setLibellePays(String libellePays) {
        this.libellePays = libellePays;
    }

    public List<Individuu> getIndividus() {
        return this.individus;
    }

    public void setIndividus(List<Individuu> individus) {
        this.individus = individus;
    }

    public Individuu addIndividus(Individuu individus) {
        getIndividus().add(individus);
        individus.setPay(this);

        return individus;
    }

    public Individuu removeIndividus(Individuu individus) {
        getIndividus().remove(individus);
        individus.setPay(null);

        return individus;
    }

}