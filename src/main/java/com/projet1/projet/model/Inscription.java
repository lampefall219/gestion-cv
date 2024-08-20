package com.projet1.projet.model;



import java.util.Arrays;
import java.util.Date;

public class Inscription {


    private String nom;

    private String prenom;

    private String adresse;


    private String email;


    private byte[] photo;


    private java.sql.Date dateNaissance;

    private String telephone;

    private String sexe;

    private String nationalite;

    private String situationMatrimoniale;

    private String description;
    private Education education;
    public Inscription() {
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
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

    @Override
    public String toString() {
        return "Inscription{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", email='" + email + '\'' +
                ", photo=" + Arrays.toString(photo) +
                ", dateNaissance=" + dateNaissance +
                ", telephone='" + telephone + '\'' +
                ", sexe='" + sexe + '\'' +
                ", nationalite='" + nationalite + '\'' +
                ", situationMatrimoniale='" + situationMatrimoniale + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
