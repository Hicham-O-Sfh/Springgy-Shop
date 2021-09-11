package com.example.demo.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "INDIVIDU")
public class /*User*/ Individuu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_individu", unique = true, nullable = false)
    private Integer idIndividu;

    @Column(name = "accepte_nouveaute_par_mail")
    private Boolean accepteNouveauteParMail;

    @Column(length = 150)
    private String adresse;

    @Override
    public String toString() {
        return "Individuu{" +
                "idIndividu=" + idIndividu +
                ", accepteNouveauteParMail=" + accepteNouveauteParMail +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", motDePasseAccount='" + motDePasseAccount + '\'' +
                ", nomClient='" + nomClient + '\'' +
                ", prenomClient='" + prenomClient + '\'' +
                ", prenomClientFacultatif='" + prenomClientFacultatif + '\'' +
                ", telephone='" + telephone + '\'' +
                ", pay=" + pay +
                ", sexeBean=" + sexeBean +
                ", status='" + status + '\'' +
                '}';
    }

    @Email(message = "Email is invalid")
    @Column(length = 100)
    private String email;

    @Column(name = "mot_de_passe_account")
    @Length(min = 5, message = "Password should be at least 5 characters")
    private String motDePasseAccount;

    @Column(name = "nom_client", length = 50)
    private String nomClient;

    @Column(name = "prenom_client", length = 50)
    private String prenomClient;

    @Column(name = "prenom_client_facultatif", length = 50)
    private String prenomClientFacultatif;

    @Column(length = 15)
    private String telephone;

    //bi-directional many-to-one association to Commande
    @OneToMany(mappedBy = "individu")
    private List<Commande> commandes;

    //bi-directional many-to-one association to Pay
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pays_")
    private Pay pay;

    //bi-directional many-to-one association to Sexe
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sexe_")
    private Sexe sexeBean;

    //bi-directional many-to-one association to Panier
    @OneToMany(mappedBy = "individu")
    private List<Panier> paniers;

    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "auth_user_role",
            joinColumns = @JoinColumn(name = "id_individu"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Integer getIdIndividu() {
        return idIndividu;
    }

    public void setIdIndividu(Integer idIndividu) {
        this.idIndividu = idIndividu;
    }

    public Boolean getAccepteNouveauteParMail() {
        return accepteNouveauteParMail;
    }

    public void setAccepteNouveauteParMail(Boolean accepteNouveauteParMail) {
        this.accepteNouveauteParMail = accepteNouveauteParMail;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasseAccount() {
        return motDePasseAccount;
    }

    public void setMotDePasseAccount(String motDePasseAccount) {
        this.motDePasseAccount = motDePasseAccount;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getPrenomClient() {
        return prenomClient;
    }

    public void setPrenomClient(String prenomClient) {
        this.prenomClient = prenomClient;
    }

    public String getPrenomClientFacultatif() {
        return prenomClientFacultatif;
    }

    public void setPrenomClientFacultatif(String prenomClientFacultatif) {
        this.prenomClientFacultatif = prenomClientFacultatif;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public List<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(List<Commande> commandes) {
        this.commandes = commandes;
    }

    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public Sexe getSexeBean() {
        return sexeBean;
    }

    public void setSexeBean(Sexe sexeBean) {
        this.sexeBean = sexeBean;
    }

    public List<Panier> getPaniers() {
        return paniers;
    }

    public void setPaniers(List<Panier> paniers) {
        this.paniers = paniers;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Panier addPanier(Panier panier) {
        getPaniers().add(panier);
        panier.setIndividu(this);

        return panier;
    }

    public Panier removePanier(Panier panier) {
        getPaniers().remove(panier);
        panier.setIndividu(null);

        return panier;
    }

    public Commande addCommande(Commande commande) {
        getCommandes().add(commande);
        commande.setIndividu(this);

        return commande;
    }

    public Commande removeCommande(Commande commande) {
        getCommandes().remove(commande);
        commande.setIndividu(null);

        return commande;
    }

}

