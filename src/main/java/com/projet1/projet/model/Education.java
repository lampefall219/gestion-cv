package com.projet1.projet.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomFormation;
    private String description;
    private java.sql.Date dateDebut;
    private java.sql.Date dateFin;
    private String etablissement;
    private String ville;
    private String pays;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public Education() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(java.sql.Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(java.sql.Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", nomFormation='" + nomFormation + '\'' +
                ", description='" + description + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", etablissement='" + etablissement + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
