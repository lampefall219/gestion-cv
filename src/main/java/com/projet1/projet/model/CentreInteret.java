package com.projet1.projet.model;

import jakarta.persistence.*;

@Entity

public class CentreInteret {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String proprietes;
    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    // Getters et Setters

    public CentreInteret() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getProprietes() {
        return proprietes;
    }

    public void setProprietes(String proprietes) {
        this.proprietes = proprietes;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "CentreInteret{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", proprietes='" + proprietes + '\'' +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
