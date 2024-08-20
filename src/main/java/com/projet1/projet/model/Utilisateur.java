package com.projet1.projet.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Le nom est obligatoire.")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire.")
    private String prenom;
    @NotBlank(message = "L'adresse est obligatoire.")
    private String adresse;
    @Email(message = "Email invalide.")
    @NotBlank(message = "L'email est obligatoire.")
    private String email;

    @Lob
    @Column(columnDefinition="LONGBLOB")
    private byte[] photo;

   @Past(message = "La date de naissance doit être dans le passé.")
    private java.sql.Date dateNaissance;
    @NotBlank(message = "Le numéro de téléphone est obligatoire.")
    private String telephone;
    @NotBlank(message = "Le sexe  obligatoire.")
    private String sexe;

    @NotBlank(message = "La nationalite  est obligatoire.")
    private String nationalite;

    @NotBlank(message = "La situationMatrimoniale  est obligatoire.")
    private String situationMatrimoniale;
    @NotBlank(message = "La description de téléphone est obligatoire.")
    private String description;
       @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Qualification> qualifications;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<SystemeEx> knowledges;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Language> languages;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<Experience> experiences;
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL)
    private List<CentreInteret> centreInterets;

    // Getters and Setters


    public List<CentreInteret> getCentreInterets() {
        return centreInterets;
    }

    public void setCentreInterets(List<CentreInteret> centreInterets) {
        this.centreInterets = centreInterets;
    }

    public Utilisateur() {
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(java.sql.Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getSituationMatrimoniale() {
        return situationMatrimoniale;
    }

    public void setSituationMatrimoniale(String situationMatrimoniale) {
        this.situationMatrimoniale = situationMatrimoniale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public List<SystemeEx> getKnowledges() {
        return knowledges;
    }

    public void setKnowledges(List<SystemeEx> knowledges) {
        this.knowledges = knowledges;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }
}
