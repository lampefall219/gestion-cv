package com.projet1.projet.services;


import com.projet1.projet.model.*;
import com.projet1.projet.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private EducationRepository educationRepository;

    @Autowired
    private QualificationRepository qualificationRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private CentreInteretRepository centreInteretRepository;

    @Autowired
    private ExperienceRepository experienceRepository;

    @Autowired
    private SystemeExRepository systemeExRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Utilisateur existe(String login) {
        return utilisateurRepository.findByEmail(login);
    }

    public List<Utilisateur> getAll() {
        return utilisateurRepository.findAll();
    }
  public Utilisateur save(Utilisateur utilisateur){
        utilisateurRepository.save(utilisateur);
        return utilisateur;
  }

    public void saveUtilisateur(Utilisateur utilisateur) {
        // Sauvegarder l'utilisateur
        Utilisateur savedUtilisateur = save(utilisateur);

        // Sauvegarder les formations
        if (savedUtilisateur.getEducations() != null) {
            for (Education education : savedUtilisateur.getEducations()) {
                education.setUtilisateur(savedUtilisateur);
                if (education.getId() != null && educationRepository.existsById(education.getId())) {
                    educationRepository.save(education);
                } else {
                    educationRepository.save(education);
                }
            }
        }

        // Sauvegarder les qualifications
        if (savedUtilisateur.getQualifications() != null) {
            for (Qualification qualification : savedUtilisateur.getQualifications()) {
                qualification.setUtilisateur(savedUtilisateur);
                if (qualification.getId() != null && qualificationRepository.existsById(qualification.getId())) {
                    qualificationRepository.save(qualification);
                } else {
                    qualificationRepository.save(qualification);
                }
            }
        }

        // Sauvegarder les expériences
        if (savedUtilisateur.getExperiences() != null) {
            for (Experience experience : savedUtilisateur.getExperiences()) {
                experience.setUtilisateur(savedUtilisateur);
                if (experience.getId() != null && experienceRepository.existsById(experience.getId())) {
                    experienceRepository.save(experience);
                } else {
                    experienceRepository.save(experience);
                }
            }
        }

        // Sauvegarder les connaissances spécifiques
        if (savedUtilisateur.getKnowledges() != null) {
            for (SystemeEx systemeEx : savedUtilisateur.getKnowledges()) {
                Category category = new Category();
                category.setNom(systemeEx.getNom());
                category.setDescription(systemeEx.getDescription());
                systemeEx.setUtilisateur(savedUtilisateur);
                if (systemeEx.getCategory() != null && categoryRepository.existsById(systemeEx.getCategory().getId())) {
                    Category c = categoryRepository.save(category);
                    systemeEx.setCategory(c);
                    systemeExRepository.save(systemeEx);
                } else {
                    Category c = categoryRepository.save(category);
                    systemeEx.setCategory(c);
                    systemeExRepository.save(systemeEx);
                }
            }
        }

        // Sauvegarder les langues
        if (savedUtilisateur.getLanguages() != null) {
            for (Language language : savedUtilisateur.getLanguages()) {
                language.setUtilisateur(savedUtilisateur);
                if (language.getId() != null && languageRepository.existsById(language.getId())) {
                    languageRepository.save(language);
                } else {
                    languageRepository.save(language);
                }
            }
        }

        // Sauvegarder les centres d'intérêt
        if (savedUtilisateur.getCentreInterets() != null) {
            for (CentreInteret centreInteret : savedUtilisateur.getCentreInterets()) {
                centreInteret.setUtilisateur(savedUtilisateur);
                if (centreInteret.getId() != null && centreInteretRepository.existsById(centreInteret.getId())) {
                    centreInteretRepository.save(centreInteret);
                } else {
                    centreInteretRepository.save(centreInteret);
                }
            }
        }
    }

    public void SupprimerUtilisateur(Optional<Utilisateur> utilisateur) {
        if (utilisateur.isPresent()) {
            Utilisateur utilisateurToDelete = utilisateur.get();

            // Supprimer les formations
            for (Education education : utilisateurToDelete.getEducations()) {
                educationRepository.delete(education);
            }

            // Supprimer les qualifications
            for (Qualification qualification : utilisateurToDelete.getQualifications()) {
                qualificationRepository.delete(qualification);
            }

            // Supprimer les expériences
            for (Experience experience : utilisateurToDelete.getExperiences()) {
                experienceRepository.delete(experience);
            }

            // Supprimer les connaissances spécifiques
            for (SystemeEx systemeEx : utilisateurToDelete.getKnowledges()) {
                systemeExRepository.delete(systemeEx);
                categoryRepository.delete(systemeEx.getCategory());
            }

            // Supprimer les langues
            for (Language language : utilisateurToDelete.getLanguages()) {
                languageRepository.delete(language);
            }

            // Supprimer les centres d'intérêt
            for (CentreInteret centreInteret : utilisateurToDelete.getCentreInterets()) {
                centreInteretRepository.delete(centreInteret);
            }

            // Enfin, supprimer l'utilisateur lui-même
            utilisateurRepository.delete(utilisateurToDelete);
        }
    }

    public Optional<Utilisateur> getUtilisateurById(Long id) {
        return utilisateurRepository.findById(id);
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    public Page<Utilisateur> findAll(Pageable pageable) {
        return utilisateurRepository.findAll(pageable);
    }
}
