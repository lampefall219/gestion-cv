package com.projet1.projet.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<SystemeEx> systems;

    public Category() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SystemeEx> getSystems() {
        return systems;
    }

    public void setSystems(List<SystemeEx> systems) {
        this.systems = systems;
    }

    @Override
    public String toString() {
        return nom;
    }
}
