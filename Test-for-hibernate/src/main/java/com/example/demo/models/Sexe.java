package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the sexe database table.
 */
@Entity
@Table(name = "sexe")
@NamedQuery(name = "Sexe.findAll", query = "SELECT s FROM Sexe s")
public class Sexe {
//	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sexe", unique = true, nullable = false)
    private Integer idSexe;

    @Column(name = "libelle_sexe", length = 25)
    private String libelleSexe;

    //bi-directional many-to-one association to Individuu
    @OneToMany(mappedBy = "sexeBean")
    private List<Individuu> individus;

    public Sexe() {
    }

    public Sexe(String libelleSexe) {
        this.libelleSexe = libelleSexe;
    }

    public Integer getIdSexe() {
        return this.idSexe;
    }

    public void setIdSexe(Integer idSexe) {
        this.idSexe = idSexe;
    }

    public String getLibelleSexe() {
        return this.libelleSexe;
    }

    public void setLibelleSexe(String libelleSexe) {
        this.libelleSexe = libelleSexe;
    }

    public List<Individuu> getIndividus() {
        return this.individus;
    }

    public void setIndividus(List<Individuu> individus) {
        this.individus = individus;
    }

    public Individuu addIndividus(Individuu individus) {
        getIndividus().add(individus);
        individus.setSexeBean(this);

        return individus;
    }

    public Individuu removeIndividus(Individuu individus) {
        getIndividus().remove(individus);
        individus.setSexeBean(null);

        return individus;
    }

}