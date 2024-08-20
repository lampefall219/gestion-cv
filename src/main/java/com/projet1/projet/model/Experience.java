package com.projet1.projet.model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String entreprise;
    private java.sql.Date dateDebut;
    private java.sql.Date dateFin;
    private String posteOccupe;
    private String descriptionMission;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    public Experience() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
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

    public String getPosteOccupe() {
        return posteOccupe;
    }

    public void setPosteOccupe(String posteOccupe) {
        this.posteOccupe = posteOccupe;
    }

    public String getDescriptionMission() {
        return descriptionMission;
    }

    public void setDescriptionMission(String descriptionMission) {
        this.descriptionMission = descriptionMission;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id=" + id +
                ", entreprise='" + entreprise + '\'' +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", posteOccupe='" + posteOccupe + '\'' +
                ", descriptionMission='" + descriptionMission + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
