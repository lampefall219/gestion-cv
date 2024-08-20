package com.projet1.projet.controller;


import com.projet1.projet.model.Utilisateur;
import com.projet1.projet.repository.LanguageRepository;
import com.projet1.projet.repository.QualificationRepository;
import com.projet1.projet.services.UtilisateurService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Optional;
@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private QualificationRepository qualificationRepository;
    @Autowired
    private LanguageRepository langueRepository;


    @GetMapping("/")
    public String listUtilisateur(Model model,  @RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Utilisateur> userPage = utilisateurService.findAll(pageable);
        model.addAttribute("userPage", userPage);
        return "utilisateur/index";
    }
    @GetMapping("/new")
    public String createUtilisateurForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateur/add";
    }
    @GetMapping("/view/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurService.getUtilisateurById(id);
        if (optionalUtilisateur.isPresent()) {
            model.addAttribute("utilisateur", optionalUtilisateur.get());
            return "compte/cv";
        } else {
            model.addAttribute("errorMessage", "Utiisateur not found");
            return "error";
        }
    }
    @GetMapping("/photo/{id}")
    public ResponseEntity<ByteArrayResource> getUserPhoto(@PathVariable Long id) {
        Optional<Utilisateur> user = utilisateurService.getUtilisateurById(id);
        if (user == null || user.get().getPhoto() == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"photo.jpg\"")
                .contentType(MediaType.IMAGE_JPEG)
                .body(new ByteArrayResource(user.get().getPhoto()));
    }
    @PostMapping
    public String saveUser(@ModelAttribute("Utilisateur") Utilisateur user, RedirectAttributes redirectAttributes, BindingResult result, @RequestParam("file") MultipartFile file) {

        try {
            if (!file.isEmpty()) {
                user.setPhoto(file.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "utilisateur/add";
        }

        utilisateurService.saveUtilisateur(user);
        redirectAttributes.addFlashAttribute("success", "cv généré! Vous pouvez maintenant vous connecter pour le télécharger.");

        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurService.getUtilisateurById(id);
        if (optionalUtilisateur.isPresent()) {
            model.addAttribute("Utilisateur", optionalUtilisateur.get());
            return "utilisateur/edit";
        } else {
            model.addAttribute("errorMessage", "Utiisateur not found");
            return "error";
        }
    }


   /* @PostMapping("/{id}")
    public String updateUtilisateur(@PathVariable Long id, @ModelAttribute("user") Utilisateur utilisateur) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurService.getUtilisateurById(id);
        if (optionalUtilisateur.isPresent()) {
            Utilisateur existingUtilisateur = optionalUtilisateur.get();
            existingUtilisateur.setNom(utilisateur.getNom());
            existingUtilisateur.setPrenom(utilisateur.getPrenom());
            existingUtilisateur.setPhoto(utilisateur.getPhoto());
            existingUtilisateur.setAdresse(utilisateur.getAdresse());
            existingUtilisateur.setDateNaissance(utilisateur.getDateNaissance());
            existingUtilisateur.setDescription(utilisateur.getDescription());
            existingUtilisateur.setEmail(utilisateur.getEmail());
            existingUtilisateur.setEducations(utilisateur.getEducations());
            existingUtilisateur.setExperiences(utilisateur.getExperiences());
            existingUtilisateur.setLanguages(utilisateur.getLanguages());
            existingUtilisateur.setKnowledges(utilisateur.getKnowledges());
            existingUtilisateur.setDescription(utilisateur.getDescription());
            existingUtilisateur.setNationalite(utilisateur.getNationalite());
            existingUtilisateur.setSituationMatrimoniale(utilisateur.getSituationMatrimoniale());
            existingUtilisateur.setSexe(utilisateur.getSexe());

            utilisateurService.saveUtilisateur(existingUtilisateur);
            return "redirect:/utilisateur/";
        } else {
            // Handle the case when the product is not found
            return "redirect:/utilisateur/";
        }
    }*/
   @PostMapping("/{id}")
   public String updateUser(@PathVariable("id") Long id, @Valid @ModelAttribute("Utilisateur") Utilisateur user, BindingResult result, @RequestParam("file") MultipartFile file) {

       try {
           if (!file.isEmpty()) {
               user.setPhoto(file.getBytes());
           } else {
               // Conserver l'ancienne photo si un nouveau fichier n'est pas téléchargé
               Optional<Utilisateur> existingUser = utilisateurService.getUtilisateurById(id);
               if (existingUser != null) {
                   user.setPhoto(existingUser.get().getPhoto());
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
           return "utilisateur/edt";
       }

       utilisateurService.saveUtilisateur(user);
       return "redirect:/";
   }

    @GetMapping("/delete/{id}")
    public String deleteTest(@PathVariable Long id) {
        Optional<Utilisateur> optionalUtilisateur = utilisateurService.getUtilisateurById(id);
        if (optionalUtilisateur.isPresent()) {
           utilisateurService.SupprimerUtilisateur(optionalUtilisateur);
            utilisateurService.deleteUtilisateur(id);
        } else {
            // Handle the case when the product is not found
            // Optionally add a message or redirect
        }
        return "redirect:/";
    }
}
