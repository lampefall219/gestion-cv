package com.projet1.projet.services;


import com.projet1.projet.model.*;
import com.projet1.projet.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {
    @Autowired
    UtilisateurRepository utilisateurRepository;



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
    public Utilisateur existe(String login){
        Utilisateur utilisateur= utilisateurRepository.findByEmail(login);
        if (utilisateur!=null){
            return utilisateur;
        }else {
            return null;
        }
    }
    public List<Utilisateur> getAll(){
        return utilisateurRepository.findAll();
    }
    public  void  saveUtilisateur(Utilisateur utilisateur){
        // Sauvegarder l'utilisateur
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        if (utilisateur.getEducations()!=null){
            for (Education education : utilisateur.getEducations()) {
                education.setUtilisateur(savedUtilisateur);
                educationRepository.save(education);
            }
        }
        if (utilisateur.getEducations()!=null){
            for (Qualification qualification : utilisateur.getQualifications()) {
                qualification.setUtilisateur(savedUtilisateur);
                qualificationRepository.save(qualification);
            }
        }
        if (utilisateur.getExperiences()!=null){
            // Sauvegarder les experiences
            for (Experience experience : utilisateur.getExperiences()) {
                experience.setUtilisateur(savedUtilisateur);
                experienceRepository.save(experience);
            }
        }

         if(utilisateur.getKnowledges()!=null) {
             // Sauvegarder les systemeEx

             for (SystemeEx systemeEx : utilisateur.getKnowledges()) {
                 Category category = new Category();
                 category.setNom(systemeEx.getNom());
                 category.setDescription(systemeEx.getDescription());
                 systemeEx.setUtilisateur(savedUtilisateur);
                 Category c = categoryRepository.save(category);
                 systemeEx.setCategory(c);
                 systemeExRepository.save(systemeEx);
             }

         }

           if (utilisateur.getLanguages()!=null) {
               // Sauvegarder languages
               for (Language language : utilisateur.getLanguages()) {
                   language.setUtilisateur(savedUtilisateur);
                   languageRepository.save(language);
               }
           }

            if (utilisateur.getCentreInterets()!=null) {
                // Sauvegarder les centreInteret
                for (CentreInteret centreInteret : utilisateur.getCentreInterets()) {
                    centreInteret.setUtilisateur(savedUtilisateur);
                    centreInteretRepository.save(centreInteret);
                }
            }



    }
    public  void  SupprimerUtilisateur(Optional<Utilisateur> utilisateur){
        // Sauvegarder l'utilisateur


        // Sauvegarder les formations
        for (Education education : utilisateur.get().getEducations()) {

            educationRepository.delete(education);
        }

        // Sauvegarder les qualifications
        for (Qualification qualification : utilisateur.get().getQualifications()) {
            qualificationRepository.delete(qualification);
        }

        // Sauvegarder les experiences
        for (Experience experience : utilisateur.get().getExperiences()) {
            experienceRepository.delete(experience);
        }
        // Sauvegarder les systemeEx

        for (SystemeEx systemeEx : utilisateur.get().getKnowledges()) {
            systemeExRepository.delete(systemeEx);
            categoryRepository.delete(systemeEx.getCategory());

        }
        // Sauvegarder languages
        for (Language language : utilisateur.get().getLanguages()) {
            languageRepository.delete(language);
        }


        // Sauvegarder les centreInteret
        for (CentreInteret centreInteret : utilisateur.get().getCentreInterets()) {
            centreInteretRepository.delete(centreInteret);
        }
    }

    public Optional<Utilisateur> getUtilisateurById(Long id){
        return utilisateurRepository.findById(id);
    }
    public void deleteUtilisateur(Long id){
        utilisateurRepository.deleteById(id);
    }
    public Page<Utilisateur> findAll(Pageable pageable) {
        return utilisateurRepository.findAll(pageable);
    }

}
